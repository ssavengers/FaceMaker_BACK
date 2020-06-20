package com.face.facemaker.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.face.facemaker.mapper.NeutralTableMapper;
import com.face.facemaker.model.dto.Neutral_Table;
@Repository
public class NeutralTableDaoImpl implements NeutralTableDao {
	@Autowired
	NeutralTableMapper mapper;
	
	
	@Override
	public void insertNeutral(Neutral_Table neutral_table) {
		mapper.insertNeutral(neutral_table);
	}

	@Override
	public void updateNeutral(Neutral_Table neutral_table) {
		mapper.updateNeutral(neutral_table);
	}

	@Override
	public Neutral_Table selectOneNeutral(String name) {
		return mapper.selectOneNeutral(name);
	}

}
