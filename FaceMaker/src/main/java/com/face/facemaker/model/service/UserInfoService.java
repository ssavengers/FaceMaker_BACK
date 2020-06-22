package com.face.facemaker.model.service;

import com.face.facemaker.model.dto.UserInfo;

public interface UserInfoService {
	public void addUserInfo(UserInfo userinfo);
	public void deleteUserInfo(String name);
	public UserInfo selectOneUserInfo(String name);
}
