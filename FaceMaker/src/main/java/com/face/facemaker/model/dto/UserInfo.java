package com.face.facemaker.model.dto;

// UserInfo 테이블 안의 레코드 1건의 정보를 저장하기 위한 객체
public class UserInfo {
	private String id;
	private String password;
	public UserInfo() {}
	
	public UserInfo(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	@Override
	   public String toString() {
	      return id;
	   }
}
