package com.pm.app.application.vo;

import org.apache.ibatis.type.Alias;

@Alias("HousingsVO")
public class HousingsVO {
	int HousingID;
	String Name;

	public HousingsVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HousingsVO(int housingID, String name) {
		super();
		HousingID = housingID;
		Name = name;
	}

	@Override
	public String toString() {
		return "HousingsVO [HousingID=" + HousingID + ", Name=" + Name + "]";
	}

	public int getHousingID() {
		return HousingID;
	}

	public void setHousingID(int housingID) {
		HousingID = housingID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}