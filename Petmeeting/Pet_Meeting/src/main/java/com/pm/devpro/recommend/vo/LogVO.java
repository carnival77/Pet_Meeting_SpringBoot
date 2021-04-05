package com.ktds.devpro.recommend.vo;

import org.apache.ibatis.type.Alias;

@Alias("LogVO")
public class LogVO {
   String pname;
   int age;
   int family;
   String tv_name = "";
   String itn_name = "";
   String mob_name = "";
   int prev_price = -1; // 결합상품일 때만, 0 이상
   int total_price = 0; // 최종가격
   String total_service = ""; // 부가서비스
   boolean combine; // 결합상품인지 여부
   String Date;

   public LogVO() {
   }

   public LogVO(String pname, int age, int family, String tv_name, String itn_name, String mob_name, int prev_price,
         int total_price, String total_service, boolean combine, String Date) {
      this.pname = pname;
      this.age = age;
      this.family = family;
      this.tv_name = tv_name;
      this.itn_name = itn_name;
      this.mob_name = mob_name;
      this.prev_price = prev_price;
      this.total_price = total_price;
      this.total_service = total_service;
      this.combine = combine;
      this.Date =Date;
   }

   public String getPname() {
      return pname;
   }

   public void setPname(String pname) {
      this.pname = pname;
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

   public String getTv_name() {
      return tv_name;
   }

   public void setTv_name(String tv_name) {
      this.tv_name = tv_name;
   }

   public String getItn_name() {
      return itn_name;
   }

   public void setItn_name(String itn_name) {
      this.itn_name = itn_name;
   }

   public String getMob_name() {
      return mob_name;
   }

   public void setMob_name(String mob_name) {
      this.mob_name = mob_name;
   }

   public int getPrev_price() {
      return prev_price;
   }

   public void setPrev_price(int prev_price) {
      this.prev_price = prev_price;
   }

   public int getTotal_price() {
      return total_price;
   }

   public void setTotal_price(int total_price) {
      this.total_price = total_price;
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

   public String getDate() {
      return Date;
   }

   public void setDate(String Date) {
      this.Date = Date;
   }
}