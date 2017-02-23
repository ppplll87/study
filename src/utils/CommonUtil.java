package utils;

import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CommonUtil {
	
	/**
	 * Object empty check
	 * @param Object
	 * @return boolean
	 */
	public static boolean isEmpty(Object obj) {
		
		if (obj == null) {
			return true;
		} else if (obj instanceof Map) {
			return ((Map<?, ?>)obj).isEmpty();
		} else if (obj instanceof List) {
			return ((List<?>)obj).isEmpty();
		} else if (obj instanceof Object[]) {
			return (((Object[])obj).length == 0);
		} else if (obj instanceof String) {
			return "".equals(((String)obj).trim());
		} else if (obj instanceof JsonArray) {
			return ((JsonArray)obj).size() == 0;
		} else if (obj instanceof JsonObject) {
			return ((JsonObject)obj).isJsonNull();
		}
		
		return false;
	}

}
