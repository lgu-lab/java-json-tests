package org.demo.jsonmapper.impl.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.demo.jsonmapper.JsonMapper;

public class JacksonMapper<T> implements JsonMapper<T> {
	
	private final Class<T> entityClass;

	/**
	 * Constructor
	 * @param entityClass
	 */
	public JacksonMapper(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	/* (non-Javadoc)
	 * @see org.demo.jsonmapper.JsonMapper#beanToJson(java.lang.Object)
	 */
	@Override
	public String beanToJson(T bean) {
		ObjectMapper mapper = JacksonMapperSingleton.getMapper();
		try {
			return mapper.writeValueAsString(bean);
		} catch (Exception e) {
			throw new RuntimeException("Cannot convert BEAN to JSON", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.demo.jsonmapper.JsonMapper#jsonToBean(java.lang.String)
	 */
	@Override
	public T jsonToBean(String json) {
		ObjectMapper mapper = JacksonMapperSingleton.getMapper();
		if ( json != null ) {
			try {
				return mapper.readValue(json, entityClass);
			} catch (Exception e) {
				throw new RuntimeException("Cannot convert JSON to BEAN", e);
			}
		}
		else {
			return null ;
		}
	}

}
