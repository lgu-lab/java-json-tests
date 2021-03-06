package org.demo.jsonmapper.impl.gson;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonTypeAdapterForUtilDate implements JsonSerializer<Date>, JsonDeserializer<Date> {

	@Override
	public JsonElement serialize(Date data, Type type, JsonSerializationContext context) {
		if ( data != null ) {
			return new JsonPrimitive(data.getTime());
		}
		else {
			return null;
		}
	}

	@Override
	public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		if ( jsonElement != null ) {
			return new Date(jsonElement.getAsLong()); 
		}
		else {
			return null;
		}
	}

}
