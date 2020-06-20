package com.face.facemaker.mapper;

import com.face.facemaker.model.dto.UserInfo;

public interface UserInfoMapper {
	public void addUserInfo(UserInfo userinfo);
	public void deleteUserInfo(String name);
	public UserInfo login(String name, int age);
}
