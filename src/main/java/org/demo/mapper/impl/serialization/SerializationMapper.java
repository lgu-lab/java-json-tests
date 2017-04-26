package org.demo.mapper.impl.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import org.demo.mapper.StringMapper; 

public class SerializationMapper<T> implements StringMapper<T> {
	
	private final Class<T> entityClass;

	/**
	 * Constructor
	 * @param entityClass
	 */
	public SerializationMapper(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public String beanToString(T bean) {
		// 1) Serialize object to binary
		byte[] binary = serialize(bean);
		// 2) binary to Base64  
		return Base64.getEncoder().encodeToString(binary) ;
	}

	@Override
	public T stringToBean(String string) {
		// 1) Base64 to binary 
		byte[] binary = Base64.getDecoder().decode(string);
		// 2) Deserialize binary to object
		return deserialize(binary);
	}
	
	public byte[] serialize(T bean) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(bean);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			throw new RuntimeException("Cannot serialize bean (" + entityClass.getCanonicalName() + ")");
		}
		return baos.toByteArray();
	}
	
	@SuppressWarnings("unchecked")
	public T deserialize(byte[] binary) {
		Object object = null ;
		ByteArrayInputStream bais = new ByteArrayInputStream(binary);
		try {
			ObjectInputStream ois = new ObjectInputStream(bais);
			object = ois.readObject(); 
			ois.close();
		} catch (ClassNotFoundException | IOException e ) {
			throw new RuntimeException("Cannot deserialize bean (" + entityClass.getCanonicalName() + ")", e);
		}
		return (T) object ;
	}
	 
}
