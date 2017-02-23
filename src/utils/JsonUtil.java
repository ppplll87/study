package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonUtil {

	/**
	 * JsonObject copy
	 * @param obj
	 * @return
	 */
	public static JsonObject deepCopy(JsonObject obj) {
		
		if(!CommonUtil.isEmpty(obj)) {
			JsonObject copyObj = new JsonObject();
			
			for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
				copyObj.add(entry.getKey(), entry.getValue());
			}
			
			return copyObj;
		} else {
			return null;
		}
	}
	
	/**
	 * JsonArray copy
	 * @param arr
	 * @return
	 */
	public static JsonArray deepCopy(JsonArray arr) {
		
		if(!CommonUtil.isEmpty(arr)) {
			JsonArray copyArr = new JsonArray();
			
			for (JsonElement element : arr) {
				copyArr.add(element.getAsJsonObject());
			}
			return copyArr;
		} else {
			return null;
		}
	}
	
	/**
	 * JsonArray convert to ArrayList
	 * @param jsonArr
	 * @return
	 */
	public static ArrayList<Object> convertJsonArrayToArrayList(JsonArray jsonArr) {

		if(!CommonUtil.isEmpty(jsonArr)) {
			ArrayList<Object> list = new ArrayList<>();
			for(JsonElement e : jsonArr) {
				list.add(e.getAsJsonObject());
			}
			return list;
		} else {
			return null;
		}
	}
	
	/**
	 * JsonObject convert to Map (java object)
	 * @param convertTarget
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> convertJsonObjectToMap(JsonObject jsonObj) {
		
		if(!CommonUtil.isEmpty(jsonObj)) {
			Map<String, Object> data = new HashMap<>();
			for(Entry<String, JsonElement> e : jsonObj.entrySet()) {
				data.put(e.getKey(), e.getValue());
			}
			return data;
		} else {
			return null;
		}
	}
}
