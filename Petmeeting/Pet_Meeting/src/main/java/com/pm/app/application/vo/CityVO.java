package com.pm.app.application.vo;

import org.apache.ibatis.type.Alias;

@Alias("CityVO")
public class CityVO {
	int CityID;
	String Name;

	public int getCityID() {
		return CityID;
	}

	public void setCityID(int cityID) {
		CityID = cityID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public CityVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CityVO(int cityID, String name) {
		super();
		CityID = cityID;
		Name = name;
	}

	@Override
	public String toString() {
		return "CityVO [CityID=" + CityID + ", Name=" + Name + "]";
	}

}