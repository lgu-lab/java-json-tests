package org.demo.bean;

import java.io.Serializable;

public class MyBeanSqlTimestamp implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Short id ;

    private java.sql.Timestamp timestamp ;  
    
    /**
     * Default constructor
     */
    public MyBeanSqlTimestamp() {
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
    public void setTime( java.sql.Timestamp v ) {
        this.timestamp = v;
    }
    public java.sql.Timestamp getTime() {
        return this.timestamp;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(timestamp);
        return sb.toString(); 
    } 
}
