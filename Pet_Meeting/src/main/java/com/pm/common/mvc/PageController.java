package com.ktds.devpro.common.mvc;

import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * 
 * 페이징 처리를 위한 컨트롤러
 * <p>
 * 
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
public class PageController {

	/**
	 * 기본 페이지 사이즈
	 */
	@Value("${web.config.default-page-size}")
	private String defaultPageSize;

	/**
	 * 페이징 정보 셋팅
	 *
	 * @param params 현재 페이지 번호 및 페이지 사이즈
	 */
	protected void initPageConfig(Map<String, Object> params) {

    	String currentPage = (String)params.get("currentPage");
		String pageSize = (String)params.get("pageSize");

		if (currentPage == null || currentPage.equals("")) {
			currentPage = "1";
		}

		if (pageSize == null || pageSize.equals("")) {
			pageSize = defaultPageSize;
		}

		// 현재 페이지 번호
		int nPage = Integer.parseInt(currentPage);

		// 페이지당 보여줄 건수
		int nSize = Integer.parseInt(pageSize);

		int startRow = (nPage == 1) ? 1 : ((nPage - 1) * nSize) + 1;
		int endRow = startRow + nSize - 1;

		params.put("currentPage", nPage);
		params.put("pageSize", pageSize);
		params.put("startRow", startRow);
		params.put("endRow", endRow);
	}

}
