package fr.eseo.ld.proseboard.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountHistory {

	private Long idHistory;
	private Long idAccount;
	private float solde;
	private Date date;
	
	
	public AccountHistory(){
		
	}


	public Date getDate() {
		return date;
	}

	public String getDatePrintf() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return sdf.format(date);
	}
	
	public void setDate(Date date) {
		this.date = date;
	}


	public Long getIdHistory() {
		return idHistory;
	}


	public void setIdHistory(Long idHistory) {
		this.idHistory = idHistory;
	}


	public Long getIdAccount() {
		return idAccount;
	}


	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}


	public float getSolde() {
		return solde;
	}


	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	
	
	
}
