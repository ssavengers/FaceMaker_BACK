package com.face.facemaker.mapper;

import com.face.facemaker.model.dto.UserInfo;

public interface UserInfoMapper {
	public void addUserInfo(UserInfo userinfo);
	public void deleteUserInfo(String id);
	public UserInfo login(String id, String password);
}
