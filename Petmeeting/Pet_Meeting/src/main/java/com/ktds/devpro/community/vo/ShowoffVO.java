package com.pm.app.community.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("ShowoffVO")
public class ShowoffVO {
	int SID;
	String Text;
	Date Date;
	int UID;
	int ImgID;
	@Override
	public String toString() {
		return "ShowoffVO [SID=" + SID + ", Text=" + Text + ", Date=" + Date + ", UID=" + UID + ", ImgID=" + ImgID
				+ "]";
	}
	public ShowoffVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowoffVO(int sID, String text, java.sql.Date date, int uID, int imgID) {
		super();
		SID = sID;
		Text = text;
		Date = date;
		UID = uID;
		ImgID = imgID;
	}
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public int getImgID() {
		return ImgID;
	}
	public void setImgID(int imgID) {
		ImgID = imgID;
	}

	
}