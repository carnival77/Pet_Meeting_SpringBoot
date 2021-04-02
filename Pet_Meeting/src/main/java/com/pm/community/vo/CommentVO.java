package com.pm.community.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("CommentVO")
public class CommentVO {
	int CID;
	String Text;
	Date Date;
	int CID_ReplyTo;
	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentVO(int cID, String text, java.sql.Date date, int cID_ReplyTo, int uID, int wID) {
		super();
		CID = cID;
		Text = text;
		Date = date;
		CID_ReplyTo = cID_ReplyTo;
		UID = uID;
		WID = wID;
	}
	@Override
	public String toString() {
		return "CommentVO [CID=" + CID + ", Text=" + Text + ", Date=" + Date + ", CID_ReplyTo=" + CID_ReplyTo + ", UID="
				+ UID + ", WID=" + WID + "]";
	}
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		CID = cID;
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
	public int getCID_ReplyTo() {
		return CID_ReplyTo;
	}
	public void setCID_ReplyTo(int cID_ReplyTo) {
		CID_ReplyTo = cID_ReplyTo;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public int getWID() {
		return WID;
	}
	public void setWID(int wID) {
		WID = wID;
	}
	int UID;
	int WID;

	
}