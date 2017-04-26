package org.demo.bean;

import java.io.Serializable;

/**
 * Java bean for entity "Driver" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 * 
 * @author Telosys Tools Generator
 *
 */
public class MyBeanSqlTime implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Short id ; // short // Id or Primary Key


    private java.sql.Time time ;  // date -> Date 
    
    /**
     * Default constructor
     */
    public MyBeanSqlTime() {
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
    public void setTime( java.sql.Time v ) {
        this.time = v;
    }
    public java.sql.Time getTime() {
        return this.time;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(time);
        return sb.toString(); 
    } 

}
