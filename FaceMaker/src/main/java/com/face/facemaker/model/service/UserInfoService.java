package com.face.facemaker.model.service;


import java.sql.SQLException;
import java.util.List;

import com.face.facemaker.model.dto.UserInfo;

public interface UserInfoService {
	public void addUserInfo(UserInfo userinfo);
	public void deleteUserInfo(String id);
	public UserInfo login(String id,String password) throws SQLException;
	
}
