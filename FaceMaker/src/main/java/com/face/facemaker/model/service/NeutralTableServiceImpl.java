package com.face.facemaker.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.face.facemaker.model.dao.NeutralTableDao;
import com.face.facemaker.model.dto.Neutral_Table;

@Service
public class NeutralTableServiceImpl implements NeutralTableService{
	@Autowired
	NeutralTableDao dao;

	@Override
	public void insertNeutral(Neutral_Table neutral_table) {
		dao.insertNeutral(neutral_table);
	}

	@Override
	public void updateNeutral(Neutral_Table neutral_table) {
		dao.updateNeutral(neutral_table);
	}

	@Override
	public Neutral_Table selectOneNeutral(String name) {
		return dao.selectOneNeutral(name);
	}
}
