package org.demo.jsonmapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.demo.bean.MyBeanSqlTimestamp;
import org.demo.jsonmapper.JsonMapper;
import org.demo.jsonmapper.impl.gson.GsonMapper;
import org.demo.jsonmapper.impl.jackson.JacksonMapper;
import org.junit.Test;

/**
 * 
 */
public class MyBeanSqlTimestampJson {

	private JsonMapper<MyBeanSqlTimestamp> getGsonMapper() {
		return new GsonMapper<MyBeanSqlTimestamp>(MyBeanSqlTimestamp.class);
	}
	private JsonMapper<MyBeanSqlTimestamp> getJacksonMapper() {
		return new JacksonMapper<MyBeanSqlTimestamp>(MyBeanSqlTimestamp.class);
	}

	//----- JACKSON
	@Test
	public void testJacksonSqlTime() {
		java.sql.Time time = java.sql.Time.valueOf("12:34:56");
		testConvert(getJacksonMapper(), new java.sql.Timestamp(time.getTime()));
	}	
	@Test
	public void testJacksonSqlTime2() {
		java.util.Date now = new java.util.Date();
		testConvert(getJacksonMapper(), new java.sql.Timestamp(now.getTime()));
	}	

	//----- GSON
	@Test
	public void testGsonSqlTime() {
		java.sql.Time time = java.sql.Time.valueOf("12:34:56");
		testConvert(getGsonMapper(), new java.sql.Timestamp(time.getTime()));
	}	
	@Test
	public void testGsonSqlTime2() {
		java.util.Date now = new java.util.Date();
		testConvert(getGsonMapper(), new java.sql.Timestamp(now.getTime()));
	}	
	@Test
	public void testGsonSqlTimeNull() {
		testConvert(getGsonMapper(), null);
	}	

	private void testConvert(JsonMapper<MyBeanSqlTimestamp> m, java.sql.Timestamp timestamp) {
		
		System.out.println("-------------------------------------------");
		System.out.println("Mapper : " + m.getClass().getSimpleName() );
		if ( timestamp != null ) {
			System.out.println("Given  : " + timestamp.getClass().getCanonicalName() + " : '" + timestamp + "' ( " + timestamp.getTime() + " )");
		}
		MyBeanSqlTimestamp bean1 = new MyBeanSqlTimestamp();
		bean1.setId((short)1); // "id" : short
		bean1.setTime(timestamp); // "birthDate" : java.util.Date

    	System.out.println("Instance 1 : " + bean1 );

		String json = m.beanToJson(bean1);
    	System.out.println(json );
		
    	MyBeanSqlTimestamp bean2 = m.jsonToBean(json);
    	System.out.println("Instance 2 : " + bean2 );

		assertNotNull(bean2);
		
		assertEquals(bean1.getTime(), bean2.getTime() ); 
		if ( bean1.getTime() != null ) {
			assertTrue( bean1.getTime().compareTo(bean2.getTime()) == 0 ); 
			assertTrue( bean1.getTime().equals(bean2.getTime()) );
		}
    	System.out.println("Test OK");
	}	
}
