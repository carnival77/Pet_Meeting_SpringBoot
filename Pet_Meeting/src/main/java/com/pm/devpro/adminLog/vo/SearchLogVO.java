package com.ktds.devpro.adminLog.vo;

import org.apache.ibatis.type.Alias;

@Alias("SearchLogVO")
public class SearchLogVO {
	int age;
	int family;
	boolean combine = false;

	boolean tv_select;
	boolean itn_select;
	boolean mob_select;
	
	
	public SearchLogVO() {
		super();
	}

	public SearchLogVO(int age, int family, boolean combine, boolean tv_select, boolean itn_select,
			boolean mob_select) {
		super();
		this.age = age;
		this.family = family;
		this.combine = combine;
		this.tv_select = tv_select;
		this.itn_select = itn_select;
		this.mob_select = mob_select;
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getFamily() {
		return family;
	}

	public void setFamily(int family) {
		this.family = family;
	}

	public boolean isCombine() {
		return combine;
	}

	public void setCombine(boolean combine) {
		this.combine = combine;
	}

	public boolean isTv_select() {
		return tv_select;
	}

	public void setTv_select(boolean tv_select) {
		this.tv_select = tv_select;
	}

	public boolean isItn_select() {
		return itn_select;
	}

	public void setItn_select(boolean itn_select) {
		this.itn_select = itn_select;
	}

	public boolean isMob_select() {
		return mob_select;
	}

	public void setMob_select(boolean mob_select) {
		this.mob_select = mob_select;
	}

	@Override
	public String toString() {
		return "SearchLogVO [age=" + age + ", family=" + family + ", combine=" + combine + ", tv_select=" + tv_select
				+ ", itn_select=" + itn_select + ", mob_select=" + mob_select + "]";
	}
	

	
}
