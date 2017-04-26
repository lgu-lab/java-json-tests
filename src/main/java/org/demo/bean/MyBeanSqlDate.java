package org.demo.bean;

import java.io.Serializable;

public class MyBeanSqlDate implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Short id ; // short // Id or Primary Key

    private java.sql.Date birthDate ;  // date -> Date 
    

    public MyBeanSqlDate() {
        super();
    }
    
    //----------------------------------------------------------------------
	public void setId( Short id ) {
        this.id = id ;
    }
	public Short getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    public void setBirthDate( java.sql.Date birthDate ) {
        this.birthDate = birthDate;
    }
    public java.sql.Date getBirthDate() {
        return this.birthDate;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(birthDate);
        return sb.toString(); 
    } 
}
