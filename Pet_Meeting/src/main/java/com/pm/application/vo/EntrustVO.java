package com.pm.application.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("EntrustVO")
public class EntrustVO {
	int EID;
	String Text;
	Date StartDate;
	Date EndDate;
	int Preypayment;
	int Toypayment;
	Date CreatedDate;
	int CityID;
	int UID;

	public EntrustVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntrustVO(int eID, String text, Date startDate, Date endDate, int preypayment, int toypayment,
			Date createdDate, int cityID, int uID) {
		super();
		EID = eID;
		Text = text;
		StartDate = startDate;
		EndDate = endDate;
		Preypayment = preypayment;
		Toypayment = toypayment;
		CreatedDate = createdDate;
		CityID = cityID;
		UID = uID;
	}

	public int getEID() {
		return EID;
	}

	public void setEID(int eID) {
		EID = eID;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public int getPreypayment() {
		return Preypayment;
	}

	public void setPreypayment(int preypayment) {
		Preypayment = preypayment;
	}

	public int getToypayment() {
		return Toypayment;
	}

	public void setToypayment(int toypayment) {
		Toypayment = toypayment;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public int getCityID() {
		return CityID;
	}

	public void setCityID(int cityID) {
		CityID = cityID;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	@Override
	public String toString() {
		return "EntrustVO [EID=" + EID + ", Text=" + Text + ", StartDate=" + StartDate + ", EndDate=" + EndDate
				+ ", Preypayment=" + Preypayment + ", Toypayment=" + Toypayment + ", CreatedDate=" + CreatedDate
				+ ", CityID=" + CityID + ", UID=" + UID + "]";
	}

}