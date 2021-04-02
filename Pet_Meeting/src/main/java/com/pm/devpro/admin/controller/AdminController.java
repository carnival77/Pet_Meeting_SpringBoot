package com.ktds.devpro.admin.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ktds.devpro.admin.service.AdminService;
import com.ktds.devpro.admin.vo.AdminVO;
import com.ktds.devpro.adminLog.controller.AdminLogController;

//@Controller
@RestController
@RequestMapping("/admin")
public class AdminController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdminService managerService;

	private AdminLogController adminlog;

	public HttpSessionUtils sessionUtils;
	
//	public AdminVO adminvo;

	@GetMapping // cmd로 클라이언트로부터 받아와서 처리.
	public List<AdminVO> getManagerList() {
		logger.debug(">> Manager 전체목록 조회");
		return managerService.getManagerList();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getManagerById(@PathVariable String id) {
		AdminVO manager = managerService.getManager(id);
		if (manager == null) {
			return new ResponseEntity<>("Manager Not Found ", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.OK).body(manager);
	}

//	@GetMapping("/{password}")
//	public ResponseEntity<?> getUserByPassword(@PathVariable String uid) {
//		ManagerVO user = userService.getUserWithPassword(uid);
//		if (user == null) {
//			return new ResponseEntity<>("User Not Found ", HttpStatus.NOT_FOUND);
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(user);
//	}

	@PostMapping
	public ResponseEntity<?> registerManager(@RequestBody AdminVO paramVo) {
		// @RequestBody : 클라이언트로부터 얻는 json Body(VO)
		int cnt = managerService.registerManager(paramVo);
		if (cnt == 1) {
			return ResponseEntity.status(HttpStatus.OK).body(managerService.getManagerList());
		} else {
			return new ResponseEntity<>("User insert failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// uid를 입력 받고 uid를 제외한 다른 특성들을 모두 바꿀 수 있다. uid를 변경해야 하면
	// @PutMapping("/{password}")를 이용해 uid대신 password를 파라미터로 받는다.
	@PutMapping("/{id}")
	public ResponseEntity<?> updateManager(@PathVariable String id, @RequestBody AdminVO paramVo) {
//		MyUserVO user = userService.getUserWithPassword(uid);
		AdminVO manager = managerService.getManager(id);
		if (manager == null) {
			return new ResponseEntity<>("Manager not found", HttpStatus.NOT_FOUND);
		}
		paramVo.setId(manager.getId());
		logger.debug(">>> Update Manager 입력 " + paramVo);
		int cnt = managerService.updateManager(paramVo);
		if (cnt == 1) {
			return ResponseEntity.status(HttpStatus.OK).body(managerService.getManagerList());
		} else {
			return new ResponseEntity<>("Manager update failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{pwd}")
	public ResponseEntity<?> deleteManager(@PathVariable String pwd) {
		int cnt = managerService.deleteManager(pwd);
		if (cnt == 1)
			return ResponseEntity.status(HttpStatus.OK).body(managerService.getManagerList());
		else
			return new ResponseEntity<>("Manager Delete Failed ", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 1. 로그인 페이지로 이동. "login"를 반환. 이후 프론트에서 지정한 페이지로 이동하게끔 한다.
	@GetMapping("/login")
	public String login() {

		return "login";
	}

	// 로그인 성공 시 프론트 반환값 선택지
	// 1. "redirect:/"를 보낸다. 프론트에서 지정한 페이지로 이동하게끔 한다.
	// 2. 백엔드에서 uri를 지정하고 그 페이지로 이동하게끔 한다.
	@PostMapping("/login")
	public ResponseEntity<?> loginManager(@RequestBody AdminVO adminVO, HttpSession session, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes rttr) throws Exception {

//		System.out.println("매니저 테스트 : " + adminVO);

//		session = request.getSession(true);
		sessionUtils.session = request.getSession(true);
		session = sessionUtils.session;
//		session = request.getSession(true);
//		sessionUtils.getSession() = session;
//		session = sessionUtils.getSession();
//		sessionUtils.setSession(session);

		// 아이디 입력하세요!
		if (adminVO.getId() == null && adminVO.getPwd() != null) {
			return new ResponseEntity<>("insert Id", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// 비밀번호 입력하세요!
		else if (adminVO.getPwd() == null && adminVO.getId() != null) {
			return new ResponseEntity<>("insert password", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// 아이디 비번 입력했으면
		else if (adminVO.getId() != null && adminVO.getPwd() != null) {
			// 아이디 존재 여부 확인
			AdminVO manager = managerService.getManager(adminVO.getId());
			// 해당 아이디 없으면 "Manager Not Found" 리턴
			if (manager == null) {
				return new ResponseEntity<>("Manager Not Found ", HttpStatus.NOT_FOUND);
			}
			// 해당 아이디 있으면 비밀 번호 맞는 지 확인
			else {
				// 입력된 adminVO와 id로 검색된 manager의 비밀번호가 일치하는 지 확인
				if (manager.getPwd().equals(adminVO.getPwd())) {
					// 비밀번호도 일치하면 기존 관리자 로그인 세션 있는 지 확인 후 있으면 제거
					if (session != null) {
						session.removeAttribute(HttpSessionUtils.ADMIN_SESSION_KEY);
					}
					// 그 후 새롭게 관리자 로그인 세션 시작
					AdminVO loginManager = managerService.loginManager(adminVO);
					if (loginManager != null) {
						
						session.setAttribute(HttpSessionUtils.ADMIN_SESSION_KEY, manager);
						sessionUtils.adminvo = manager;
						
//						sessionUtils.session.setAttribute(HttpSessionUtils.ADMIN_SESSION_KEY, manager);
//						sessionUtils.getSession().setAttribute(HttpSessionUtils.ADMIN_SESSION_KEY, manager);
						
						System.out.println("관리자 로그인 성공");
//						adminlog.getAdminAllLogList();
						// 어디로 이동할 지 얘기. 지금은 adminlog

						// HttpSessionUtils에 session과 admin_session_key 설정
						
						
						
//						HttpSessionUtils.session.setAttribute(name, value);

						response.sendRedirect("/adminlog");
//						return new ResponseEntity(HttpStatus.OK);

//						return ResponseEntity.status(HttpStatus.OK).body(adminlog);

//						adminlog.getAdminAllLogList();
//						
//						ResponseEntity.status(HttpStatus.OK).body(loginManager);
					}
				}
				// 비밀번호 일치하지 않으면 wrong Password 리턴
				else {
					return new ResponseEntity<>("wrong Password", HttpStatus.NOT_FOUND);
				}
			}

		}
		// 아무것도 입력하지 않았을 시
		return new ResponseEntity<>("insert info", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 로그아웃 시, "login" 반환
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// session.invalidate();
		/* session에 해당하는 이름을 매개변수로 넣어줘야 한다 */
		session.removeAttribute(HttpSessionUtils.ADMIN_SESSION_KEY);
		return "login";
	}

}
