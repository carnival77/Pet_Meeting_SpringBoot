package com.ktds.devpro.admin.vo;

import org.apache.ibatis.type.Alias;

@Alias("AdminVO")
public class AdminVO {
	private String id;
	private String pwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public AdminVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public AdminVO(String id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "AdminVO [id=" + id + ", pwd=" + pwd + "]";
	}

}
