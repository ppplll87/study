package utils;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

public class ConfigUtil {
	
	private static Configurations configs = new Configurations();
	private static Configuration config;
	
	static {
		try {
			config = configs.properties(new File("resources/properties/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * property 가져오기
	 * @param key
	 * @return
	 */
	public static String getProperties(String key) {
		return config.getString(key);
	}
	
	/**
	 * 문자열 배열형태의 property 가져오기
	 * @param key
	 * @return
	 */
	public static String[] getArrProperties(String key) {
		return config.getStringArray(key);
	}
}
