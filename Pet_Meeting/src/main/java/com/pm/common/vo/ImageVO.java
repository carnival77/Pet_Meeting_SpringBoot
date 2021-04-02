package com.pm.common.vo;

import org.apache.ibatis.type.Alias;

@Alias("ResultVO")
public class ImageVO {
	int imgID;
	String Filename;
	String MimeType;
	String OriginalName;
	int Size;

	@Override
	public String toString() {
		return "ImageVO [imgID=" + imgID + ", Filename=" + Filename + ", MimeType=" + MimeType + ", OriginalName="
				+ OriginalName + ", Size=" + Size + "]";
	}

	public int getImgID() {
		return imgID;
	}

	public void setImgID(int imgID) {
		this.imgID = imgID;
	}

	public String getFilename() {
		return Filename;
	}

	public void setFilename(String filename) {
		Filename = filename;
	}

	public String getMimeType() {
		return MimeType;
	}

	public void setMimeType(String mimeType) {
		MimeType = mimeType;
	}

	public String getOriginalName() {
		return OriginalName;
	}

	public void setOriginalName(String originalName) {
		OriginalName = originalName;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}

	public ImageVO(int imgID, String filename, String mimeType, String originalName, int size) {
		super();
		this.imgID = imgID;
		Filename = filename;
		MimeType = mimeType;
		OriginalName = originalName;
		Size = size;
	}

	public ImageVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}