package com.face.facemaker.model.dao;

import java.sql.SQLException;

import com.face.facemaker.model.dto.UserInfo;

public interface UserInfoDao {
/* crud(insert,delete,update,select) selectAll하지말기! 
 * 1.userInfo.java
 * 2.userinfodao
 * 3.userinfodaoimpl.java
 * 4.houseinfodaoimpl.java
 */
	public void addUserInfo(UserInfo userinfo) throws SQLException;
	public void deleteUserInfo(String name)throws SQLException;
	public UserInfo login(String name,int age)throws SQLException;
}