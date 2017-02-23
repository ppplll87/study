package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

public static String PATTERN_DB_COLUMN = "_(.)";
	
	/**
	 * AAA_AAA 형식의 문자열을 camelCase로 변환
	 * pattern : _(.)
	 * @param str 
	 * @return
	 */
	public static String convertDBColumnToCamel (String str) {
		StringBuffer sb = new StringBuffer();
		
		if(!CommonUtil.isEmpty(str)) {
			Pattern p = Pattern.compile(PATTERN_DB_COLUMN);
			Matcher m = p.matcher(str);
			/**
			 * TEST_DATA_TEST2 -> test_data_test2
			 * appendRepalcement(StringBuffer sb, String replacement) 
			 * 일치하는 패턴이 나타날 때까지의 모든 문자들을 버퍼(sb)로 옮기고 찾아진
			 * 문자열 대신 교체 문자열(replacement)로 채워 넣는다.  
			 * appendTail(StringBuffer sb) 
			 * 캐릭터 시퀀스의 현재 위치 이후의 문자들을 버퍼(sb)에 복사해 넣는다. 
			 */
			while(m.find()) {
				m.appendReplacement(sb, m.group(1).toUpperCase());
			}
			m.appendTail(sb);
		}
		
		return sb.toString();
	}
	
	/**
	 * 정규식 변환
	 * @param str 변환대상 문자열
	 * @param pattern 변환대상 문자
	 * @param addPattern 추가할 문자
	 * @return
	 */
	public static String addRegexPattern (String str, String targetPattern, String addPattern) {
		StringBuffer sb = new StringBuffer();
		
		if(!CommonUtil.isEmpty(str)) {
			Pattern p = Pattern.compile(targetPattern);
			Matcher m = p.matcher(str);
			
			while(m.find()) {
				m.appendReplacement(sb, m.group(0) + addPattern);
			}
			m.appendTail(sb);
		}
		
		return sb.toString();
	}
	
	/**
	 * Only a-zA-Z
	 *
	 * @param str
	 * @return
	 */
	public static boolean isAlphaOnly(final String str) {
		if (CommonUtil.isEmpty(str))
		throw new IllegalArgumentException("String not found");

		return str.matches("^[a-zA-Z]*$");
	}
	
	/**
	 * Only 0-9
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNumberOnly(final String str) {
		if (CommonUtil.isEmpty(str))
		throw new IllegalArgumentException("String not found");

		return str.matches("^[0-9]*$");
	}
	
	/**
	 * 
	 * @param pattern
	 * @param content
	 * @return
	 */
	public static Matcher getMatcher(String pattern, String content) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(content);
		return m;
	}
}
