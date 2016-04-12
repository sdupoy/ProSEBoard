package fr.eseo.ld.proseboard.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String REDMINE_ADDRESS = "https://192.168.4.14/redmine/users.json?key=25961e7cf25593ce8c74907cce763ed3cf77110e";

    private Long id;
    private Long idRedmine;
    private String mail;
    private String password;
    private String lastName;
    private String firstName;
    private List<Status> statuses;
    private List<Permission> permissions;
    private Long idAccount;
    private Account account;
    private Team team;
    private boolean isAbsent;

    public User() {
        // Empty constructor
    }

    public Long getSession(Long id) {
        Long user;
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.getStudentBySession(id);
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        return user;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRedmine() {
        return idRedmine;
    }

    public void setIdRedmine(Long idRedmine) {
        this.idRedmine = idRedmine;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permission) {
        this.permissions = permission;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Team getTeam() {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
                .openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try{
            team = userMapper.getTeam(this.id);
        }finally{
            sqlSession.close();
        }
        return team;
    }
    
    public List<Team> getTeamList() {
    	List<Team> t;
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
                .openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try{
            t = userMapper.getTeamList(this.id);
        }finally{
            sqlSession.close();
        }
        return t;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean hasPermission(String permissionName) {
        if (getPermissions() != null) {
            for (Permission permission : getPermissions()) {
                if (permission.getName().equals(permissionName)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean hasOneOfPermissions(String[] permissionsNames){
        if (getPermissions() != null) {
            for (String permissionName : permissionsNames) {
                if (this.hasPermission(permissionName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasStatus(String statusName) {
        if (getStatuses() != null) {
            for (Status status : getStatuses()) {
                if (status.getName().equals(statusName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasStatus(String[] statusesNames){
        if (getStatuses() != null) {
            for (String statusName : statusesNames) {
                if (this.hasStatus(statusName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAvailable(Date start, Date end) {
        boolean result = true;
        int availability;
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
                .openSession();
        EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
        try {
            availability = eventMapper.existsBetween(this, start, end);
            if (availability > 0) {
                result = false;
            }
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public boolean createOnRedmine() throws IOException, KeyManagementException, NoSuchAlgorithmException{
        byte[] outputBytes = null;

        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = getTrustManager();

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);


        HttpsURLConnection httpcon = (HttpsURLConnection)(new URL(REDMINE_ADDRESS).openConnection());
        httpcon.setDoOutput(true);
        httpcon.setRequestProperty("Content-Type", "application/json");
        httpcon.setRequestProperty("Accept", "application/json");
        httpcon.setRequestMethod("POST");
        httpcon.connect();
        outputBytes = new String("{\"user\": "
                + "{\"login\": \""+getMail()+"\","
                + "\"firstname\": \""+getFirstName()+"\","
                + "\"lastname\": \""+getLastName()+"\","
                + "\"mail\": \""+getMail()+"\","
                + "\"password\": \""+getPassword()+"\"}}")
        .getBytes("UTF-8");

        try (OutputStream output = httpcon.getOutputStream()) {
            output.write(outputBytes);
        }

        InputStream response = httpcon.getInputStream();
        int status = httpcon.getResponseCode();
        if(status == 201){

            String contentType = httpcon.getHeaderField("Content-Type");
            String charset = null;
            String json = "";

            for (String param : contentType.replace(" ", "").split(";")) {
                if (param.startsWith("charset=")) {
                    charset = param.split("=", 2)[1];
                    break;
                }
            }

            if (charset != null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(response, charset))) {
                    for (String line; (line = reader.readLine()) != null;) {
                        json += line;
                    }
                }
            }
            JSONObject redmineUser = new JSONObject(json);
            setIdRedmine(Long.valueOf(redmineUser.getJSONObject("user").getLong("id")));              
            return true;
        }else{
            return false;
        }
    }
    
    private TrustManager[] getTrustManager(){
        return new TrustManager[] {
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return getAcceptedIssuers();
                    }
                    
                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        //We don't want to check the certificate
                    }
                    
                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        //We don't want to check the certificate
                    }
                }
            };
    }

    public boolean isAbsent() {
        return isAbsent;
    }

    public void setAbsent(boolean isAbsent) {
        this.isAbsent = isAbsent;
    }
    
    public boolean hasMyInfosPanel(){
        String[] authorizedPermissions = {"my_account", "publish_competences", "publish_available"};
        return hasOneOfPermissions(authorizedPermissions);
    }
    
    public boolean hasAdminPanel(){
        String[] authorizedPermissions = {"manage_users", "create_user", "create_session"};
        return hasOneOfPermissions(authorizedPermissions);
    }
	
	public Long getIdEventIfAttended(Long idEv) {
		Long result = null;
    	SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		try{
			List<Long> idEvents = userMapper.getIdEventsAttended(this.id);
			if(idEvents.contains(idEv)){
				result=idEv;
			}
		}finally{
			sqlSession.close();
		}
		return result;
	}
    
    public boolean hasTeamPanel(){
        String[] authorizedStatuses = {"team_leader", "team_member"};
        String[] authorizedPermissions = {"book_consultationOrTraining", "validate_consultationOrTraining", "pay_members", "edit_account", };
        return hasOneOfPermissions(authorizedPermissions) || hasStatus(authorizedStatuses);
    }
    
    public boolean hasAuditPanel(){
        String[] authorizedStatuses = {"planifier_audit", "create_audit", "see_all_audits", "publicate_audit", "see_team_audits", "see_my_audits", "see_audits_client"};
        return hasOneOfPermissions(authorizedStatuses);
    }
    
    public boolean hasConsultingPanel(){
        String[] authorizedStatuses = {"accept_consultationOrTraining", "see_request_team", "manage_consulting_report", "charge_team_consulting"};
        return hasOneOfPermissions(authorizedStatuses);
    }
    
    public boolean hasTrainingPanel(){
        String[] authorizedStatuses = {"accept_consultationOrTraining", "see_request_team", "create_training", "publish_training", "create_training_report","charge_team_training"};
        return hasOneOfPermissions(authorizedStatuses);
    }

}
