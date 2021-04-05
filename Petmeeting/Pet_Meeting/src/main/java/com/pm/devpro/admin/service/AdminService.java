package com.ktds.devpro.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.devpro.admin.mapper.AdminMapper;
import com.ktds.devpro.admin.vo.AdminVO;

@Service
public class AdminService {
	@Autowired
	private AdminMapper managerMapper;

	public List<AdminVO> getManagerList() {
		return managerMapper.selectManagerList();
	}

	public AdminVO getManager(String id) {
		return managerMapper.selectManager(id);
	}

	public int registerManager(AdminVO paramVo) {
		return managerMapper.registerManager(paramVo);
	}

	public int updateManager(AdminVO paramVo) {
		return managerMapper.updateManager(paramVo);
	}

	public int deleteManager(String pwd) {
		return managerMapper.deleteManager(pwd);
	}

	public AdminVO loginManager(AdminVO paramVo) throws Exception {
		return managerMapper.loginManager(paramVo);
	}

}

//