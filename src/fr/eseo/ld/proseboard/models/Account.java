package fr.eseo.ld.proseboard.models;

import java.io.Serializable;

public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idAccount;
    private float balance;

    public Account(){
        setBalance(0);
    }

    public Account(float balance, Long idAccount){
        this.balance = balance;
        this.idAccount = idAccount;
    }

    public Account(float balance){
        this.balance = balance;
    }

    public Long getIdAccount(){
        return this.idAccount;
    }

    public void setIdAccount(Long idA){
        this.idAccount=idA;
    }

    public float getBalance(){
        return this.balance;
    }

    public void setBalance(float balance){
        this.balance=balance;
    }
}
