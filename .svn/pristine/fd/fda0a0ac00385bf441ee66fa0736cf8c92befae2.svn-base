package fr.eseo.ld.proseboard.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RedmineEvent {
    private Long id;
    private int tackerId;
    private String subject;
    private String description;
    private int statusId;
    private Date startDate;
    private Date closedDate;
    
    public RedmineEvent(){
    	// empty constructor
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public int getTackerId() {
        return tackerId;
    }
    
    public void setTackerId(int tackerId) {
        this.tackerId = tackerId;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getDescription() {
        return description.replaceAll("\n", "<br />").replaceAll("\r", "").replaceAll("\"", "&quot;");
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getStatusId() {
        return statusId;
    }
    
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public String getStartDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(startDate);
    }
    
    public Date getClosedDate() {
        return closedDate;
    }
    
    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }
    
    public String getClosedDateString() {
        Date date = null;
        if(getClosedDate() != null){
            date = getClosedDate();
        }else{
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(getStartDate().getTime());
            cal.add(Calendar.DATE, 1);
            date = new Date(cal.getTimeInMillis());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }
}
