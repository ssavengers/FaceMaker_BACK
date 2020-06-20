package com.face.facemaker.model.service;

import java.sql.SQLException;
import java.util.List;

import com.face.facemaker.model.dto.UserInfo;

public interface UserInfoService {
	public void addUserInfo(UserInfo userinfo);
	public void deleteUserInfo(String name);
	public UserInfo login(String name,int age) throws SQLException;
	
}
