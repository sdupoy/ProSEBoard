package fr.eseo.ld.proseboard.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {

    private Long id;

    private String name;
    private Long nbTeam;
    private Date startDate;
    private Date endDate;
    private boolean isOpen;
    private Long idTemplate;
    
    public Session(){	
    }

    public Session(String name, Long nbTeam, Date startDate, Date endDate){
        this.name = name;
        this.nbTeam = nbTeam;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getNbTeam() {
        return nbTeam;
    }
    public void setNbTeam(Long nbTeam) {
        this.nbTeam = nbTeam;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSlashStartDate(){
        return slashDate(this.startDate);
    }

    public String getSlashEndDate(){
        return slashDate(this.endDate);
    }
    
    
    public String getEndDatePrintf() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(endDate);
	}
    
    public String getStartDatePrintf() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(startDate);
	}
    
    protected String slashDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public boolean isOpen(){
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Long getIdTemplate() {
        return idTemplate;
    }

    public void setIdTemplate(Long idTemplate) {
        this.idTemplate = idTemplate;
    }
}
