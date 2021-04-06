package com.pm.app.community.vo;

import org.apache.ibatis.type.Alias;

@Alias("WorryVO")
public class WorryVO {
	int tvId = 0;
	String tvName = "";
	String tvQuality = "";
	int tvChannel = 0;
	int tvDue = 0;
	int tvPrice = 0;
	String tvService = "";

	int itnId = 0;
	String itnName = "";
	int itnSpeed = 0;
	int itnPrice = 0;
	String itnService = "";

	int mobId = 0;
	String mobName = "";

	int mobData = 0;
	int mobVoice = 0;
	int mobMessage = 0;
	String mobService = "";
	int mobPrice = 0;

	int combId = 0;
	String combName = "";
	int combPrice = 0;
	String combService = "";

	String pname="";
	int prevPrice = -1;		// 할인 전 가격(결합 상품만 값 변경)
	int totalPrice = 0;		// 총 금액
	String total_service="";	// 부가서비스 내용
	
	boolean combine = false;	// 단일이면 false, 결합이면 true

	public WorryVO() {
	}

	public WorryVO(int tvId, String tvName, String tvQuality, int tvChannel, int tvDue, int tvPrice, String tvService,
			int itnId, String itnName, int itnSpeed, int itnPrice, String itnService, int mobId, String mobName,
			int mobData, int mobVoice, int mobMessage, String mobService, int mobPrice, int combId, String combName,
			int combPrice, String combService, int prevPrice, int totalPrice, String total_service, boolean combine) {
		this.tvId = tvId;
		this.tvName = tvName;
		this.tvQuality = tvQuality;
		this.tvChannel = tvChannel;
		this.tvDue = tvDue;
		this.tvPrice = tvPrice;
		this.tvService = tvService;
		this.itnId = itnId;
		this.itnName = itnName;
		this.itnSpeed = itnSpeed;
		this.itnPrice = itnPrice;
		this.itnService = itnService;
		this.mobId = mobId;
		this.mobName = mobName;
		this.mobData = mobData;
		this.mobVoice = mobVoice;
		this.mobMessage = mobMessage;
		this.mobService = mobService;
		this.mobPrice = mobPrice;
		this.combId = combId;
		this.combName = combName;
		this.combPrice = combPrice;
		this.combService = combService;
		this.prevPrice = prevPrice;
		this.totalPrice = totalPrice;
		this.total_service = total_service;
		this.combine = combine;
	}

	public int getTvId() {
		return tvId;
	}

	public void setTvId(int tvId) {
		this.tvId = tvId;
	}

	public String getTvName() {
		return tvName;
	}

	public void setTvName(String tvName) {
		this.tvName = tvName;
	}

	public String getTvQuality() {
		return tvQuality;
	}

	public void setTvQuality(String tvQuality) {
		this.tvQuality = tvQuality;
	}

	public int getTvChannel() {
		return tvChannel;
	}

	public void setTvChannel(int tvChannel) {
		this.tvChannel = tvChannel;
	}

	public int getTvDue() {
		return tvDue;
	}

	public void setTvDue(int tvDue) {
		this.tvDue = tvDue;
	}

	public int getTvPrice() {
		return tvPrice;
	}

	public void setTvPrice(int tvPrice) {
		this.tvPrice = tvPrice;
	}

	public String getTvService() {
		return tvService;
	}

	public void setTvService(String tvService) {
		this.tvService = tvService;
	}

	public int getItnId() {
		return itnId;
	}

	public void setItnId(int itnId) {
		this.itnId = itnId;
	}

	public String getItnName() {
		return itnName;
	}

	public void setItnName(String itnName) {
		this.itnName = itnName;
	}

	public int getItnSpeed() {
		return itnSpeed;
	}

	public void setItnSpeed(int itnSpeed) {
		this.itnSpeed = itnSpeed;
	}

	public int getItnPrice() {
		return itnPrice;
	}

	public void setItnPrice(int itnPrice) {
		this.itnPrice = itnPrice;
	}

	public String getItnService() {
		return itnService;
	}

	public void setItnService(String itnService) {
		this.itnService = itnService;
	}

	public int getMobId() {
		return mobId;
	}

	public void setMobId(int mobId) {
		this.mobId = mobId;
	}

	public String getMobName() {
		return mobName;
	}

	public void setMobName(String mobName) {
		this.mobName = mobName;
	}

	public int getMobData() {
		return mobData;
	}

	public void setMobData(int mobData) {
		this.mobData = mobData;
	}

	public int getMobVoice() {
		return mobVoice;
	}

	public void setMobVoice(int mobVoice) {
		this.mobVoice = mobVoice;
	}

	public int getMobMessage() {
		return mobMessage;
	}

	public void setMobMessage(int mobMessage) {
		this.mobMessage = mobMessage;
	}

	public String getMobService() {
		return mobService;
	}

	public void setMobService(String mobService) {
		this.mobService = mobService;
	}

	public int getMobPrice() {
		return mobPrice;
	}

	public void setMobPrice(int mobPrice) {
		this.mobPrice = mobPrice;
	}

	public int getCombId() {
		return combId;
	}

	public void setCombId(int combId) {
		this.combId = combId;
	}

	public String getCombName() {
		return combName;
	}

	public void setCombName(String combName) {
		this.combName = combName;
	}

	public int getCombPrice() {
		return combPrice;
	}

	public void setCombPrice(int combPrice) {
		this.combPrice = combPrice;
	}

	public String getCombService() {
		return combService;
	}

	public void setCombService(String combService) {
		this.combService = combService;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrevPrice() {
		return prevPrice;
	}

	public void setPrevPrice(int prevPrice) {
		this.prevPrice = prevPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTotal_service() {
		return total_service;
	}

	public void setTotal_service(String total_service) {
		this.total_service = total_service;
	}

	public boolean isCombine() {
		return combine;
	}

	public void setCombine(boolean combine) {
		this.combine = combine;
	}

	@Override
	public String toString() {
		return "ResultVO [tvId=" + tvId + ", tvName=" + tvName + ", tvQuality=" + tvQuality + ", tvChannel=" + tvChannel
				+ ", tvDue=" + tvDue + ", tvPrice=" + tvPrice + ", tvService=" + tvService + ", itnId=" + itnId
				+ ", itnName=" + itnName + ", itnSpeed=" + itnSpeed + ", itnPrice=" + itnPrice + ", itnService="
				+ itnService + ", mobId=" + mobId + ", mobName=" + mobName + ", mobData=" + mobData + ", mobVoice="
				+ mobVoice + ", mobMessage=" + mobMessage + ", mobService=" + mobService + ", mobPrice=" + mobPrice
				+ ", combId=" + combId + ", combName=" + combName + ", combPrice=" + combPrice + ", combService="
				+ combService + ", pname=" + pname + ", prevPrice=" + prevPrice + ", totalPrice=" + totalPrice
				+ ", total_service=" + total_service + ", combine=" + combine + "]";
	}

	
}