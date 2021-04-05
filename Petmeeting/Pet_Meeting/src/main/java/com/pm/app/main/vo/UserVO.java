package com.pm.app.main.vo;

import org.apache.ibatis.type.Alias;

@Alias("ResultVO")
public class UserVO {
	int UID;
	String Username;
	String Password;
	int imgID;
	String Email;
	String Phone;

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getImgID() {
		return imgID;
	}

	public void setImgID(int imgID) {
		this.imgID = imgID;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	@Override
	public String toString() {
		return "UserVO [UID=" + UID + ", Username=" + Username + ", Password=" + Password + ", imgID=" + imgID
				+ ", Email=" + Email + ", Phone=" + Phone + "]";
	}

	public UserVO(int uID, String username, String password, int imgID, String email, String phone) {
		super();
		UID = uID;
		Username = username;
		Password = password;
		this.imgID = imgID;
		Email = email;
		Phone = phone;
	}

	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}