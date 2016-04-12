package fr.eseo.ld.proseboard.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AvailableUser {
	private Long idUser;
	private Date dateStart;
	private Date dateEnd;
	
	
	public AvailableUser(){
		
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public Date getDateStart() {
		return dateStart;
	}


	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}


	public Date getDateEnd() {
		return dateEnd;
	}


	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	public String getDateStartString(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        return sdf.format(dateStart);
	}
	
	public String getDateEndString(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        return sdf.format(dateEnd);
	}
	
	
	
}
