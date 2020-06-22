package com.face.facemaker.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.face.facemaker.model.dao.AngerTableDao;
import com.face.facemaker.model.dto.Anger_Table;
@Service
public class AngerTableServiceImpl implements AngerTableService{
	@Autowired
	AngerTableDao dao;
	
	
	@Override
	public void insertAnger(Anger_Table anger_table) {
		dao.insertAnger(anger_table);
	}

	@Override
	public void updateAnger(Anger_Table anger_table) {
		dao.updateAnger(anger_table);
	}

	@Override
	public Anger_Table selectOneAnger(String name) {
		return dao.selectOneAnger(name);
	}
}
