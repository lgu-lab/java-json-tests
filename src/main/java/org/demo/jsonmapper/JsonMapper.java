package org.demo.jsonmapper;

public interface JsonMapper<T> {
	
	/**
	 * Converts the given bean to a JSON string
	 * @param bean
	 * @return
	 */
	public String beanToJson(T bean) ;
	
	/**
	 * Converts the given JSON string to a bean instance
	 * @param json
	 * @return
	 */
	public T jsonToBean(String json) ;

}
