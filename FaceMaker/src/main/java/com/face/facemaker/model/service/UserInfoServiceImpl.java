package com.face.facemaker.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.face.facemaker.model.dao.UserInfoDao;
import com.face.facemaker.model.dto.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao dao;

	
	@Override
	public void addUserInfo(UserInfo userinfo) {
		dao.addUserInfo(userinfo);
	}

	@Override
	public void deleteUserInfo(String name) {
		dao.deleteUserInfo(name);
	}

	@Override
	public UserInfo selectOneUserInfo(String name) {
		return dao.selectOneUserInfo(name);
	}

}
