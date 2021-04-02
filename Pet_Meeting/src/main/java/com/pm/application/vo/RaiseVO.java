package com.pm.application.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("RaiseVO")
public class RaiseVO {
	int RID;
	String Motivation;
	String CarrierPeriod;
	Date Date;
	int HousingID;
	int EID;
	int UID;
	int CityID;

	public RaiseVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RaiseVO(int rID, String motivation, String carrierPeriod, java.sql.Date date, int housingID, int eID,
			int uID, int cityID) {
		super();
		RID = rID;
		Motivation = motivation;
		CarrierPeriod = carrierPeriod;
		Date = date;
		HousingID = housingID;
		EID = eID;
		UID = uID;
		CityID = cityID;
	}

	@Override
	public String toString() {
		return "RaiseVO [RID=" + RID + ", Motivation=" + Motivation + ", CarrierPeriod=" + CarrierPeriod + ", Date="
				+ Date + ", HousingID=" + HousingID + ", EID=" + EID + ", UID=" + UID + ", CityID=" + CityID + "]";
	}

	public int getRID() {
		return RID;
	}

	public void setRID(int rID) {
		RID = rID;
	}

	public String getMotivation() {
		return Motivation;
	}

	public void setMotivation(String motivation) {
		Motivation = motivation;
	}

	public String getCarrierPeriod() {
		return CarrierPeriod;
	}

	public void setCarrierPeriod(String carrierPeriod) {
		CarrierPeriod = carrierPeriod;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public int getHousingID() {
		return HousingID;
	}

	public void setHousingID(int housingID) {
		HousingID = housingID;
	}

	public int getEID() {
		return EID;
	}

	public void setEID(int eID) {
		EID = eID;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public int getCityID() {
		return CityID;
	}

	public void setCityID(int cityID) {
		CityID = cityID;
	}

}