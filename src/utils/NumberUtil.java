package utils;

import java.math.BigDecimal;

public class NumberUtil {
	
	/**
	 * 문자열이 숫자형태인지 여부를 반환
	 *
	 * @param str 문자열
	 * @return 문자열이 숫자형태인 경우 true
	 */
	public static boolean isNumber(String str) {
		
		if (CommonUtil.isEmpty(str)) return false;
		
		if (str.matches("^[-+]?\\d+(\\.\\d+)?$")) {
			return true;
		} else {
			try {
				@SuppressWarnings("unused")
				double doubleVal = Double.parseDouble(str);
				return true;
			} catch (NumberFormatException de) {
				try {
					@SuppressWarnings("unused")
					BigDecimal bigDecimalVal = new BigDecimal(str);
					return true;
				} catch (NumberFormatException be) {
					return false;
				}
			}
		}
	}
}
