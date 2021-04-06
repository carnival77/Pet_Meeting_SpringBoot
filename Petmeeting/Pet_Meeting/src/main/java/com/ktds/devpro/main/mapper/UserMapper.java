package com.ktds.devpro.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.pm.app.main.vo.UserVO;

@Mapper
public interface UserMapper {
   
	public List<UserVO> selectUserList();
	
	public UserVO selectUser(String email);
	
	public int registerUser(UserVO uv);
	
	public int updateUser(UserVO uv);
	
	public int deleteUser(String password);
	
	public UserVO loginUser(UserVO uv) throws Exception;
}