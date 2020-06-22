package com.face.facemaker.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.face.facemaker.model.dao.SurpriseTableDao;
import com.face.facemaker.model.dto.Surprise_Table;
@Service
public class SurpriseTableServiceImpl implements SurpriseTableService {
	@Autowired
	SurpriseTableDao dao;
	@Override
	public void insertSurprise(Surprise_Table surprise_table) {
		dao.insertSurprise(surprise_table);
	}

	@Override
	public void updateSurprise(Surprise_Table surprise_table) {
		dao.updateSurprise(surprise_table);
	}

	@Override
	public Surprise_Table selectOneSurprise(String name) {
		return dao.selectOneSurprise(name);
	}

}
