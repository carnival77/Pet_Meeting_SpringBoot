package com.ktds.devpro.adminLog.vo;

import org.apache.ibatis.type.Alias;

@Alias("ResultLogVO")
public class ResultLogVO {
	String pname="";
	int cnt=0;
	String Date;
	
	public ResultLogVO() {
	}

	public ResultLogVO(String pname, int cnt, String Date) {
		super();
		this.pname = pname;
		this.cnt = cnt;
		this.Date = Date;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	

	public String getDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

	@Override
	public String toString() {
		return "ResultLogVO [pname=" + pname + ", cnt=" + cnt + ", Date=" + Date + "]";
	}

	
}
