package com.pm.app.pet.vo;

import org.apache.ibatis.type.Alias;

@Alias("GenderVO")
public class GenderVO {
	int GenderID;
	String name;

	public int getGenderID() {
		return GenderID;
	}

	public void setGenderID(int genderID) {
		GenderID = genderID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GenderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenderVO(int genderID, String name) {
		super();
		GenderID = genderID;
		this.name = name;
	}

	@Override
	public String toString() {
		return "GenderVO [GenderID=" + GenderID + ", name=" + name + "]";
	}

	
}