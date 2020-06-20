package com.face.facemaker.model.dto;

// UserInfo 테이블 안의 레코드 1건의 정보를 저장하기 위한 객체
public class UserInfo {
	private String id;
	private String password;
	public UserInfo() {}
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	   public String toString() {
	      return id;
	   }
}
