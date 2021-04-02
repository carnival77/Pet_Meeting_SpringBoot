package com.ktds.devpro.common.utils;

/**
 * 
 * Under Barㄹ 구분된 문자열을 카멜 타입으로 변경
 * <p>
 * <pre>
 * 개정이력(Modification Information)·
 * 수정일   수정자    수정내용
 * ------------------------------------
 * 2017. 3. 16.    kt ds     최초작성
 * </pre>
 *
 * @author kt ds A.CoE(yu.chae@kt.com)
 * @since 2017. 3. 16.
 * @version 1.0.0
 * @see
 *
 */
public final class CamelUtil {
	public static String convert2CamelCase(String underScore) {
		if ((underScore.indexOf('_') < 0) && (Character.isLowerCase(underScore.charAt(0)))) {
			return underScore;
		}
		StringBuilder result = new StringBuilder();
		boolean nextUpper = false;
		int len = underScore.length();

		for (int i = 0; i < len; i++) {
			char currentChar = underScore.charAt(i);
			if (currentChar == '_') {
				nextUpper = true;
			} else if (nextUpper) {
				result.append(Character.toUpperCase(currentChar));
				nextUpper = false;
			} else {
				result.append(Character.toLowerCase(currentChar));
			}
		}

		return result.toString();
	}
}