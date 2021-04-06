package com.pm.common.utils;

import org.apache.commons.collections4.map.ListOrderedMap;

/**
 * 
 * 영문, 언더바 형태를 카멜 형태로 변경
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
public class CamelMap extends ListOrderedMap {
	private static final long serialVersionUID = 6723434363565852261L;

	public Object put(Object key, Object value) {
		return super.put(CamelUtil.convert2CamelCase((String) key), value);
	}
}