package com.face.facemaker.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.face.facemaker.model.dao.FearTableDao;
import com.face.facemaker.model.dto.Fear_Table;
@Service
public class FearTableServiceImpl implements FearTableService {
	@Autowired
	FearTableDao dao;
	
	@Override
	public void insertFear(Fear_Table fear_table) {
		dao.insertFear(fear_table);
	}

	@Override
	public void updateFear(Fear_Table fear_table) {
		dao.updateFear(fear_table);
	}

	@Override
	public Fear_Table selectOneFear(String name) {
		return dao.selectOneFear(name);
	}

	@Override
	public void deleteFear(String name) {
		dao.deleteFear(name);
	}

}
