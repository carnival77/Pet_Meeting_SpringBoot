package com.ktds.devpro.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ktds.devpro.admin.vo.AdminVO;

@Repository
@Mapper
public interface AdminMapper {
	public List<AdminVO> selectManagerList();

	public AdminVO selectManager(String id);

	public int registerManager(AdminVO managerVO);

	public int updateManager(AdminVO managerVO);

	public int deleteManager(String pwd);
	
	public AdminVO loginManager(AdminVO managerVO) throws Exception;
}