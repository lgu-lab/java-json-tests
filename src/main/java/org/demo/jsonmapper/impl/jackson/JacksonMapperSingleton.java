package org.demo.jsonmapper.impl.jackson;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Single instance of Jackson ObjectMapper <br>
 * ObjectMapper is thread-safe <br>
 * cf JavaDoc : https://fasterxml.github.io/jackson-databind/javadoc/2.6/com/fasterxml/jackson/databind/ObjectMapper.html  <br>
 * "Mapper instances are fully thread-safe provided that ALL configuration of the instance occurs before ANY read or write calls." <br>
 * 
 * @author L. Guerin
 *
 */
public class JacksonMapperSingleton {
	
	//private final static String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss" ; // ERROR
	//private final static String DATE_FORMAT = "yyyy-MM-dd" ; // OK
	private final static String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss.SSS" ; // OK
	
	private final static ObjectMapper mapper = buildMapper();

	private final static ObjectMapper buildMapper() {
		ObjectMapper mapper = new ObjectMapper();
		//mapper.setDateFormat( new SimpleDateFormat("dd-MM-yyyy hh:mm:ss") );
		//mapper.se
		mapper.setDateFormat( new SimpleDateFormat(DATE_FORMAT) );
		
		return mapper ;
	}

	public final static ObjectMapper getMapper() {
		return mapper ;
	}
}
