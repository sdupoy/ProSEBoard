package fr.eseo.ld.proseboard.models;

import java.io.Serializable;

public class Permission implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long      id;
    private String    name;

    public Permission(){
    	//Empty constructor
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId( Long id ) {
        this.id = id;
    }

    public void setName( String name ) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
