package com.face.facemaker.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.face.facemaker.mapper.SurpriseTableMapper;
import com.face.facemaker.model.dto.Surprise_Table;
@Repository
public class SurpriseTableDaoImpl implements SurpriseTableDao {
	@Autowired
	SurpriseTableMapper mapper;
	
	@Override
	public void insertSurprise(Surprise_Table surprise_table) {
		mapper.insertSurprise(surprise_table);
	}

	@Override
	public void updateSurprise(Surprise_Table surprise_table) {
		mapper.updateSurprise(surprise_table);
	}

	@Override
	public Surprise_Table selectOneSurprise(String name) {
		return mapper.selectOneSurprise(name);
	}

}
