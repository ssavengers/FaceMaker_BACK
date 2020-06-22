package com.face.facemaker.model.dao;


import com.face.facemaker.model.dto.UserInfo;

public interface UserInfoDao {
	public void addUserInfo(UserInfo userinfo) ;
	public void deleteUserInfo(String name);
	public UserInfo selectOneUserInfo(String name);

}