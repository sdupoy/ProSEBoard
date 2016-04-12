package fr.eseo.ld.proseboard.models;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Bill {
        private Long idBill;
        private Long idUserTransmitter;
        private Long idUserReceiver;
        private String subject;

        private Date date;

        private float amount;

        private String comments;

        

        public Bill(){

        }

        public Bill(Long idUserTransmitter, Long idUserReceiver, String subject, float amount, String comments, Date date){

                this.idUserTransmitter = idUserTransmitter;

                this.idUserReceiver = idUserReceiver;

                this.subject = subject;

                this.amount = amount;
	
                this.comments = comments;
	
                this.date = date;
	
        }
	
        public Long getIdBill() {
	
                return idBill;
	
        }
	
        public void setIdBill(Long idBill) {
	
                this.idBill = idBill;
	
        }
	
        public Long getIdUserTransmitter() {
	
                return idUserTransmitter;
	
        }
	
        public void setIdUserTransmitter(Long idUserTransmitter) {
	
                this.idUserTransmitter = idUserTransmitter;
	
        }
	
        public Long getIdUserReceiver() {
	
                return idUserReceiver;
	
        }
	
        public void setIdUserReceiver(Long idUserReceiver) {
	
                this.idUserReceiver = idUserReceiver;
	
        }
	
        public String getSubject() {
	
                return subject;
	
        }
	
        public void setSubject(String subject) {
	
                this.subject = subject;
	
        }
	
        public float getAmount() {
	
                return amount;
	
        }
	
        public void setAmount(float amount) {
	
                this.amount = amount;
	
        }
	
        public String getComments() {
	
                return comments;
	
        }
	
        public void setComments(String comments) {
	
                this.comments = comments;
	
        }
	
        public Date getDate() {
	
                return date;
	
        }
	
        public void setDate(Date date) {
	
                this.date = date;
	
        }
	
        public String getSimpleDate()
	
        {
	
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
               return sdf.format(date);
	
        }
	
}