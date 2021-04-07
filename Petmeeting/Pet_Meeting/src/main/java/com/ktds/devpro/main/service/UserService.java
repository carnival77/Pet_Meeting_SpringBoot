package com.ktds.devpro.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.devpro.main.mapper.UserMapper;
import com.ktds.devpro.main.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<UserVO> getUserList() {
		return userMapper.selectUserList();
	}

	public UserVO getUser(String email) {
		return userMapper.selectUser(email);
	}

	public int registerUser(UserVO paramVo) {
		return userMapper.registerUser(paramVo);
	}

	public int updateUser(UserVO paramVo) {
		return userMapper.updateUser(paramVo);
	}

	public int deleteUser(String pwd) {
		return userMapper.deleteUser(pwd);
	}

	public UserVO loginUser(UserVO paramVo) throws Exception {
		return userMapper.loginUser(paramVo);
	}
}