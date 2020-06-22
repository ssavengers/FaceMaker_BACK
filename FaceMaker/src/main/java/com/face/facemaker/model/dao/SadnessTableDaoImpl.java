package com.face.facemaker.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.face.facemaker.mapper.SadnessTableMapper;
import com.face.facemaker.model.dto.Sadness_Table;
@Repository
public class SadnessTableDaoImpl implements SadnessTableDao {
	@Autowired
	SadnessTableMapper mapper;
	
	@Override
	public void insertSadness(Sadness_Table sadness_table) {
		mapper.insertSadness(sadness_table);
	}

	@Override
	public void updateSadness(Sadness_Table sadness_table) {
		mapper.updateSadness(sadness_table);
	}

	@Override
	public Sadness_Table selectOneSadness(String name) {
		return mapper.selectOneSadness(name);
	}

	@Override
	public void deleteSadness(String name) {
		mapper.deleteSadness(name);
	}

}
