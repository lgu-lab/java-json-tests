package org.demo.jsonmapper.impl.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonTypeAdapterForSqlTimestamp implements JsonSerializer<Timestamp>, JsonDeserializer<Timestamp> {

	@Override
	public JsonElement serialize(Timestamp data, Type type, JsonSerializationContext context) {
		if ( data != null ) {
			return new JsonPrimitive(data.getTime());
		}
		else {
			return null;
		}
	}

	@Override
	public Timestamp deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		if ( jsonElement != null ) {
			return new Timestamp(jsonElement.getAsLong());
		}
		else {
			return null;
		}
	}

}
