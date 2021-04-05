package com.ktds.devpro.recommend.vo;

import java.util.Arrays;
import org.apache.ibatis.type.Alias;

@Alias("SearchVO")
public class SearchVO {
	int age;
	int family;
	int tv_due;
	String[] tv_ser;
	String tv_service;
	int itn_speed;
	int mob_data = -1;
	int mob_voice;

	@Override
	public String toString() {
		return "SearchVO [age=" + age + ", family=" + family + ", tv_due=" + tv_due + ", tv_ser="
				+ Arrays.toString(tv_ser) + ", tv_service=" + tv_service + ", itn_speed=" + itn_speed + ", mob_data="
				+ mob_data + ", mob_voice=" + mob_voice + ", mob_price=" + mob_price + "]";
	}

	int mob_price;

	public SearchVO() {
	}

	public SearchVO(int age, int family, int tv_due, String[] tv_ser, String tv_service, int itn_speed, int mob_data,
			int mob_voice) {
		this.age = age;
		this.family = family;
		this.tv_due = tv_due;
		this.tv_ser = tv_ser;
		this.tv_service = tv_service;
		this.itn_speed = itn_speed;
		this.mob_data = mob_data;
		this.mob_voice = mob_voice;
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

	public int getTv_due() {
		return tv_due;
	}

	public void setTv_due(int tv_due) {
		this.tv_due = tv_due;
	}

	public String[] getTv_ser() {
		return tv_ser;
	}

	public void setTv_ser(String[] tv_ser) {
		this.tv_ser = tv_ser;
	}

	public String getTv_service() {
		return tv_service;
	}

	public void setTv_service(String tv_service) {
		this.tv_service = tv_service;
	}

	public int getItn_speed() {
		return itn_speed;
	}

	public void setItn_speed(int itn_speed) {
		this.itn_speed = itn_speed;
	}

	public int getMob_data() {
		return mob_data;
	}

	public void setMob_data(int mob_data) {
		this.mob_data = mob_data;
	}

	public int getMob_voice() {
		return mob_voice;
	}

	public void setMob_voice(int mob_voice) {
		this.mob_voice = mob_voice;
	}

}
