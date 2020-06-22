package com.face.facemaker.model.dto;

// UserInfo 테이블 안의 레코드 1건의 정보를 저장하기 위한 객체
public class UserInfo {
	private int no;
	private String name;
	private int age;
	private String src;
	
	public UserInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public String toString() {
		return "UserInfo [no=" + no + ", name=" + name + ", age=" + age + ", src=" + src + "]";
	}

	
}
