package org.demo.mapper;

public interface StringMapper<T> {
	
	/**
	 * Converts the given bean to a JSON string
	 * @param bean
	 * @return
	 */
	public String beanToString(T bean) ;
	
	/**
	 * Converts the given JSON string to a bean instance
	 * @param json
	 * @return
	 */
	public T stringToBean(String json) ;

}
