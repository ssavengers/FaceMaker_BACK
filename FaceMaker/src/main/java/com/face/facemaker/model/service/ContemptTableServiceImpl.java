package com.face.facemaker.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.face.facemaker.model.dao.ContemptTableDao;
import com.face.facemaker.model.dto.Contempt_Table;
@Service
public class ContemptTableServiceImpl implements ContemptTableService {
	@Autowired
	ContemptTableDao dao;
	@Override
	public void insertContempt(Contempt_Table contempt_table) {
		dao.insertContempt(contempt_table);
	}

	@Override
	public void updateContempt(Contempt_Table contempt_table) {
		dao.updateContempt(contempt_table);
	}

	@Override
	public Contempt_Table selectOneContempt(String name) {
		return dao.selectOneContempt(name);
	}

	@Override
	public void deleteContempt(String name) {
		dao.deleteContempt(name);
	}

}
