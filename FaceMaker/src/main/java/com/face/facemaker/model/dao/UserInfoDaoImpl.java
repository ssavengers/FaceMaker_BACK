package com.face.facemaker.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.face.facemaker.mapper.UserInfoMapper;
import com.face.facemaker.model.dto.UserInfo;


@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	@Autowired
	UserInfoMapper mapper;
	
	@Override
	public void addUserInfo(UserInfo userinfo) {
		mapper.addUserInfo(userinfo);
	}
	@Override
	public void deleteUserInfo(String id) {
		mapper.deleteUserInfo(id);
	}

	@Override
	public UserInfo login(String id, String password) {
		return mapper.login(id, password);
	}
}