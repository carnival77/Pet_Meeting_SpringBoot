package com.ktds.devpro.adminLog.vo;

import org.apache.ibatis.type.Alias;

@Alias("ResultLogVO2")
public class ResultLogVO2 {
	int weekTotalPrice;
	int weekTotalOrder;
	int weekPrevOrderPer;
	int weekPrevPricePer;
	String month[]=new String[6];
	int thrMonthTvCnt[]= new int[6];
	int thrMonthItnCnt[]= new int[6];
	int thrMonthMobCnt[]= new int[6];
	int thrMonthCombCnt[]= new int[6];
	
	public ResultLogVO2() {
	}
	public ResultLogVO2(int weekTotalPrice, int weekTotalOrder, int weekPrevOrderPer, int weekPrevPricePer,
			String[] month, int[] thrMonthTvCnt, int[] thrMonthItnCnt, int[] thrMonthMobCnt, int[] thrMonthCombCnt) {
		this.weekTotalPrice = weekTotalPrice;
		this.weekTotalOrder = weekTotalOrder;
		this.weekPrevOrderPer = weekPrevOrderPer;
		this.weekPrevPricePer = weekPrevPricePer;
		this.month = month;
		this.thrMonthTvCnt = thrMonthTvCnt;
		this.thrMonthItnCnt = thrMonthItnCnt;
		this.thrMonthMobCnt = thrMonthMobCnt;
		this.thrMonthCombCnt = thrMonthCombCnt;
	}
	public int getWeekTotalPrice() {
		return weekTotalPrice;
	}
	public void setWeekTotalPrice(int weekTotalPrice) {
		this.weekTotalPrice = weekTotalPrice;
	}
	public int getWeekTotalOrder() {
		return weekTotalOrder;
	}
	public void setWeekTotalOrder(int weekTotalOrder) {
		this.weekTotalOrder = weekTotalOrder;
	}
	public int getWeekPrevOrderPer() {
		return weekPrevOrderPer;
	}
	public void setWeekPrevOrderPer(int weekPrevOrderPer) {
		this.weekPrevOrderPer = weekPrevOrderPer;
	}
	public int getWeekPrevPricePer() {
		return weekPrevPricePer;
	}
	public void setWeekPrevPricePer(int weekPrevPricePer) {
		this.weekPrevPricePer = weekPrevPricePer;
	}
	public String[] getMonth() {
		return month;
	}
	public void setMonth(String[] month) {
		this.month = month;
	}
	public int[] getThrMonthTvCnt() {
		return thrMonthTvCnt;
	}
	public void setThrMonthTvCnt(int[] thrMonthTvCnt) {
		this.thrMonthTvCnt = thrMonthTvCnt;
	}
	public int[] getThrMonthItnCnt() {
		return thrMonthItnCnt;
	}
	public void setThrMonthItnCnt(int[] thrMonthItnCnt) {
		this.thrMonthItnCnt = thrMonthItnCnt;
	}
	public int[] getThrMonthMobCnt() {
		return thrMonthMobCnt;
	}
	public void setThrMonthMobCnt(int[] thrMonthMobCnt) {
		this.thrMonthMobCnt = thrMonthMobCnt;
	}
	public int[] getThrMonthCombCnt() {
		return thrMonthCombCnt;
	}
	public void setThrMonthCombCnt(int[] thrMonthCombCnt) {
		this.thrMonthCombCnt = thrMonthCombCnt;
	}
}
