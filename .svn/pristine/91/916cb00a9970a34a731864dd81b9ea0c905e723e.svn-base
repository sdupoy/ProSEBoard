package fr.eseo.ld.proseboard.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Long validation;
    private Long idCreator;
    private String type;
    private Long idSession;

    public Event(){
        // Empty constructor
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String eventName) {
        this.name = eventName;
    }
    public String getDescription() {
        return description.replaceAll("\n", "<br />").replaceAll("\r", "").replaceAll("\"", "&quot;");
    }
    public void setDescription(String eventDescription) {
        this.description = eventDescription;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public String getStartDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        return sdf.format(startDate);
    }
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getEndDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        return sdf.format(endDate);
    }
    public Long getValidation() {
        return validation;
    }
    public void setValidation(Long validation) {
        this.validation = validation;
    }
    public Long getIdCreator() {
        return idCreator;
    }
    public void setIdCreator(Long idCreator) {
        this.idCreator = idCreator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

}
