package com.ktds.devpro.pet.vo;

import org.apache.ibatis.type.Alias;

@Alias("BreedVO")
public class BreedVO {
	int BreedID;
	int SpeciesID;
	String Name;
	
}