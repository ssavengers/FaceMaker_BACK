package com.face.facemaker.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.face.facemaker.mapper.ContemptTableMapper;
import com.face.facemaker.model.dto.Contempt_Table;
@Repository
public class ContemptTableDaoImpl implements ContemptTableDao{
	@Autowired
	ContemptTableMapper mapper;
	@Override
	public void insertContempt(Contempt_Table contempt_table) {
		mapper.insertContempt(contempt_table);
	}

	@Override
	public void updateContempt(Contempt_Table contempt_table) {
		mapper.updateContempt(contempt_table);
	}

	@Override
	public Contempt_Table selectOneContempt(String name) {
		return mapper.selectOneContempt(name);
	}

}
