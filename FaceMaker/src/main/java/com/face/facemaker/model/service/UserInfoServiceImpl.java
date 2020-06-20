package com.face.facemaker.model.service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.face.facemaker.model.dao.UserInfoDao;
import com.face.facemaker.model.dao.UserInfoDaoImpl;
import com.face.facemaker.model.dto.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao dao;

	
	@Override
	public void addUserInfo(UserInfo userinfo) {
		try {
			dao.addUserInfo(userinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUserInfo(String name) {
		try {
			dao.deleteUserInfo(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public UserInfo login(String name, int age) throws SQLException {
		return dao.login(name, age);
	}

}
