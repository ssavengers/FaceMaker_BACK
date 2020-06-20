package com.face.facemaker.model.dto;

// UserInfo 테이블 안의 레코드 1건의 정보를 저장하기 위한 객체
public class UserInfo {
	private String name;
	private String age;

	public UserInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}
}
