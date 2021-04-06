package com.ktds.devpro.main.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pm.app.main.service.UserService;
import com.pm.app.main.vo.UserVO;

@RestController
@RequestMapping("/service")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

   @Autowired
   public UserService service;

   @GetMapping
	public List<UserVO> getUserList() {
		logger.debug(">> User 전체목록 조회");
		return service.getUserList();
	}

	@GetMapping("/{uid}")
	public ResponseEntity<?> getUserByUid(@PathVariable String email) {
		UserVO user = service.getUser(email);
		if (user == null) {
			return new ResponseEntity<>("User Not Found ", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping
	public ResponseEntity<?> registerUser(@RequestBody UserVO paramVo) {
		// @RequestBody : 클라이언트로부터 얻는 json Body(VO)
		int cnt = service.registerUser(paramVo);
		if (cnt == 1) {
			return ResponseEntity.status(HttpStatus.OK).body(service.getUserList());
		} else {
			return new ResponseEntity<>("User insert failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// pwd를 입력 받고 uid를 제외한 다른 특성들을 모두 바꿀 수 있다.
	@PutMapping("/{pwd}")
	public ResponseEntity<?> updateUser(@PathVariable String pwd, @RequestBody UserVO paramVo) {
		
		if(pwd == paramVo.getPassword()) {
			logger.debug(">>> Update Manager 입력 " + paramVo);
			int cnt = service.updateUser(paramVo);
			if (cnt == 1) {
				return ResponseEntity.status(HttpStatus.OK).body(service.getUserList());
			} else {
				return new ResponseEntity<>("User update failed. inserted info is wrong", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}else {
			return new ResponseEntity<>("User update failed.  Password is wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{pwd}")
	public ResponseEntity<?> deleteManager(@PathVariable String pwd) {
		int cnt = service.deleteUser(pwd);
		if (cnt == 1)
			return ResponseEntity.status(HttpStatus.OK).body(service.getUserList());
		else
			return new ResponseEntity<>("User Delete Failed ", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}