package fr.eseo.ld.proseboard.models;

public class PayTeam {
	private Long idTeam;
	private Team team;
	private Long idTeamLeader;
	private User teamLeader;
	private Long idClient;
	private Long idTeamAccount;
	private Long idClientAccount;
    private String teamName;
	private int amount;
	
	public PayTeam (){
        //Empty constructor
    }
	
	public Long getIdTeam(){
		return idTeam;
	}
	
	public void setIdTeam(Long idTeam){
		this.idTeam =idTeam;
	}
	
	public Team getTeam(){
		return team;
	}
	
	public void setTeam(Team team){
		this.team = team;
	}
	
	public Long getIdTeamLeader(){
		return idTeamLeader;
	}
	
	public void setIdTeamLeader(Long idTL){
		this.idTeamLeader =idTL;
	}
	
	public User getTeamLeader(){
		return teamLeader;
	}
	
	public void setTeamLeader(User tl){
		this.teamLeader=tl;
	}
	
	public Long getIdClient(){
		return idClient;
	}
	
	public void setIdClient(Long idClient){
		this.idClient =idClient;
	}
	
	public Long getIdTeamAccount() {
        return idTeamAccount;
    }

    public void setIdTeamAccount(Long idTAcc) {
        this.idTeamAccount = idTAcc;
    }
    
    public Long getIdClientAccount() {
        return idClientAccount;
    }

    public void setIdClientAccount(Long idCAcc) {
        this.idClientAccount = idCAcc;
    }
    
    public String getTeamName(){
    	return teamName;
    }
    
    public void setTeamName(String tn){
    	this.teamName=tn;
    }
    
    public void setAmount(int amount){
    	this.amount=amount;
    }
    
    public int getAmount(){
    	return amount;
    }
}
