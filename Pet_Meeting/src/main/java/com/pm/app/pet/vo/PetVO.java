package com.pm.app.pet.vo;

import org.apache.ibatis.type.Alias;

@Alias("PetVO")
public class PetVO {
	int PID;
	String Name;
	int Year;
	int GenderID;
	int GradeRatio;
	String Description;
	int ImgID;
	int EID;
	int UID;
	int BreedID;

	@Override
	public String toString() {
		return "PetVO [PID=" + PID + ", Name=" + Name + ", Year=" + Year + ", GenderID=" + GenderID + ", GradeRatio="
				+ GradeRatio + ", Description=" + Description + ", ImgID=" + ImgID + ", EID=" + EID + ", UID=" + UID
				+ ", BreedID=" + BreedID + "]";
	}

	public PetVO(int pID, String name, int year, int genderID, int gradeRatio, String description, int imgID, int eID,
			int uID, int breedID) {
		super();
		PID = pID;
		Name = name;
		Year = year;
		GenderID = genderID;
		GradeRatio = gradeRatio;
		Description = description;
		ImgID = imgID;
		EID = eID;
		UID = uID;
		BreedID = breedID;
	}

	public PetVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getGenderID() {
		return GenderID;
	}

	public void setGenderID(int genderID) {
		GenderID = genderID;
	}

	public int getGradeRatio() {
		return GradeRatio;
	}

	public void setGradeRatio(int gradeRatio) {
		GradeRatio = gradeRatio;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getImgID() {
		return ImgID;
	}

	public void setImgID(int imgID) {
		ImgID = imgID;
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

	public int getBreedID() {
		return BreedID;
	}

	public void setBreedID(int breedID) {
		BreedID = breedID;
	}

}