package com.face.facemaker.model.dao;

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
	public void deleteUserInfo(String name) {
		mapper.deleteUserInfo(name);
	}

	@Override
	public UserInfo login(String name, String age) {
		return mapper.login(name, age);
	}
}