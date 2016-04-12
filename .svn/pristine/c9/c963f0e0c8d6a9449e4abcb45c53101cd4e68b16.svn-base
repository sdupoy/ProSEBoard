package fr.eseo.ld.proseboard.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

	private int idMessage;
	private int idEmetter;
	private int idReceiver;
	private String mailEmetter;
	private String mailReceiver;
	private Date date;
	private String contain;
	private int read;
	private int trashEmetter;
	private int trashReceiver;
	
	
	public Message(){
		
	}


	public Message(int idMessage, int idEmetter, int idReceiver,
			String mailEmetter, String mailReceiver, Date date, String contain,
			int read, int trashEmetter, int trashReceiver) {
		super();
		this.idMessage = idMessage;
		this.idEmetter = idEmetter;
		this.idReceiver = idReceiver;
		this.mailEmetter = mailEmetter;
		this.mailReceiver = mailReceiver;
		this.date = date;
		this.contain = contain;
		this.read = read;
		this.trashEmetter = trashEmetter;
		this.trashReceiver = trashReceiver;
	}


	public int getIdMessage() {
		return idMessage;
	}


	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}


	public int getIdEmetter() {
		return idEmetter;
	}


	public void setIdEmetter(int idEmeter) {
		this.idEmetter = idEmeter;
	}


	public int getIdReceiver() {
		return idReceiver;
	}


	public void setIdReceiver(int idReceiver) {
		this.idReceiver = idReceiver;
	}


	public String getMailEmetter() {
		return mailEmetter;
	}


	public void setMailEmetter(String mailEmetter) {
		this.mailEmetter = mailEmetter;
	}


	public String getMailReceiver() {
		return mailReceiver;
	}


	public void setMailReceiver(String mailReceiver) {
		this.mailReceiver = mailReceiver;
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


	public String getContain() {
		return contain;
	}


	public void setContain(String contain) {
		this.contain = contain;
	}


	public int getRead() {
		return read;
	}


	public void setRead(int read) {
		this.read = read;
	}


	public int getTrashEmetter() {
		return trashEmetter;
	}


	public void setTrashEmetter(int trashEmetter) {
		this.trashEmetter = trashEmetter;
	}


	public int getTrashReceiver() {
		return trashReceiver;
	}


	public void setTrashReceiver(int trashReceiver) {
		this.trashReceiver = trashReceiver;
	}
	
	
	
}
