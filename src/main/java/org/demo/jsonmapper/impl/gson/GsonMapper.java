package org.demo.jsonmapper.impl.gson;

import org.demo.jsonmapper.JsonMapper;

import com.google.gson.Gson; 

public class GsonMapper<T> implements JsonMapper<T> {
	
	private final Class<T> entityClass;

	/**
	 * Constructor
	 * @param entityClass
	 */
	public GsonMapper(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	/* (non-Javadoc)
	 * @see org.demo.jsonmapper.JsonMapper#beanToJson(java.lang.Object)
	 */
	@Override
	public String beanToJson(T bean) {
		Gson mapper = GsonMapperSingleton.getMapper();
		try {
			return mapper.toJson(bean);
		} catch (Exception e) {
			throw new RuntimeException("Cannot convert BEAN to JSON", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.demo.jsonmapper.JsonMapper#jsonToBean(java.lang.String)
	 */
	@Override
	public T jsonToBean(String json) {
		Gson mapper = GsonMapperSingleton.getMapper();
		if ( json != null ) {
			try {
				return mapper.fromJson(json, entityClass);
			} catch (Exception e) {
				throw new RuntimeException("Cannot convert JSON to BEAN", e);
			}
		}
		else {
			return null ;
		}
	}

}
