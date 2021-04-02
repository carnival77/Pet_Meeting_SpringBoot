package com.ktds.devpro.adminLog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.devpro.admin.controller.HttpSessionUtils;
import com.ktds.devpro.adminLog.service.AdminLogService;
import com.ktds.devpro.adminLog.vo.ResultLogVO;
import com.ktds.devpro.adminLog.vo.ResultLogVO2;
import com.ktds.devpro.adminLog.vo.SearchLogVO;

@RestController
@RequestMapping("/adminlog")
public class AdminLogController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdminLogService service;
	public HttpSessionUtils sessionUtils;
	public HttpSession session;
	public String session_key;

	@GetMapping
	public ResponseEntity<?> getAdminAllLogList() {

//		session = adminservice.getSession();
		session_key = sessionUtils.ADMIN_SESSION_KEY;
		session = sessionUtils.session;

		if (sessionUtils.isLoginAdmin(session, session_key) == true) {
			logger.debug(">> Log 전체목록 조회");
			return ResponseEntity.status(HttpStatus.OK).body(service.selectAllLog());
		} else {
			return new ResponseEntity<>("Wrong session", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/submit")
	public ResponseEntity<?> getAdminLogResult(@RequestBody SearchLogVO admininfo) {
		
		Map<String, Object> result=new HashedMap<String, Object>();
		List<ResultLogVO> selectLog = null;
		
		ResultLogVO2 selectMonthData=new ResultLogVO2();		// 최근 1개월 가입량, 가입액, 3개월치 상품 가입자 수 저장
		
		session_key = sessionUtils.ADMIN_SESSION_KEY;
		session = sessionUtils.session;
		
		if (sessionUtils.isLoginAdmin(session, session_key) == true) {
			logger.debug(">> Log 선택 ");
			
			// 1. TV+인터넷+모바일 선택시
			if ((admininfo.isTv_select() == true) && (admininfo.isItn_select() == true)
					&& (admininfo.isMob_select() == true)) {
				selectLog = service.selectTotalLog(admininfo);
			}

			// 2. TV+인터넷(홈결합) 선택시
			else if ((admininfo.isTv_select() == true) && (admininfo.isItn_select() == true)) {
				selectLog = service.selectHomeLog(admininfo);
			}

			// 3. 인터넷 + 모바일 선택시
			else if ((admininfo.isItn_select() == true) && (admininfo.isMob_select() == true)) {
				selectLog = service.selectItnMobLog(admininfo);
			}

			// 4. TV+모바일 선택시
			else if ((admininfo.isTv_select() == true) && (admininfo.isMob_select() == true)) {
				selectLog = service.selectTvMobLog(admininfo);
			}

			// 5. tv 단일 상품 선택
			else if (admininfo.isTv_select() == true) {
				selectLog = service.selectTVLog(admininfo);
			}

			// 6. 인터넷 단일 상품 선택
			else if (admininfo.isItn_select() == true) {
				selectLog = service.selectItnLog(admininfo);
			}

			// 7. 모바일 단일 상품 선택
			else if (admininfo.isMob_select() == true) {
				selectLog = service.selectMobLog(admininfo);
			}
			
			selectMonthData=service.selectWeekMonthData();
			result.put("totalData", (List<ResultLogVO>)selectLog);
			result.put("monthData", (ResultLogVO2)selectMonthData);
			
			return ResponseEntity.status(HttpStatus.OK).body(result);
			
		} else {
			return new ResponseEntity<>("Wrong session choice", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 방문객 수 데이터 출력
	@GetMapping("/visitcnt")
	public ResponseEntity<?> getVisitCnt() {

		session_key = sessionUtils.ADMIN_SESSION_KEY;
		session = sessionUtils.session;
		
		if (sessionUtils.isLoginAdmin(session, session_key) == true) {
			logger.debug(">> Log 전체목록 조회");
			return ResponseEntity.status(HttpStatus.OK).body(service.visitCntPrint());
		} else {
			return new ResponseEntity<>("Wrong session", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}