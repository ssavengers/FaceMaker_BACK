package com.face.facemaker.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.face.facemaker.model.dao.SadnessTableDao;
import com.face.facemaker.model.dto.Sadness_Table;
@Service
public class SadnessTableServiceImpl implements SadnessTableService {
	@Autowired
	SadnessTableDao dao;
	
	@Override
	public void insertSadness(Sadness_Table sadness_table) {
		dao.insertSadness(sadness_table);
	}

	@Override
	public void updateSadness(Sadness_Table sadness_table) {
		dao.updateSadness(sadness_table);
	}

	@Override
	public Sadness_Table selectOneSadness(String name) {
		return dao.selectOneSadness(name);
	}

	@Override
	public void deleteSadness(String name) {
		dao.deleteSadness(name);
	}

}
