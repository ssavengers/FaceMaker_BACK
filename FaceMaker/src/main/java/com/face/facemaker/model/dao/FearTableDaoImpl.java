package com.face.facemaker.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.face.facemaker.mapper.FearTableMapper;
import com.face.facemaker.model.dto.Fear_Table;
@Repository
public class FearTableDaoImpl implements FearTableDao {
	@Autowired
	FearTableMapper mapper;
	@Override
	public void insertFear(Fear_Table fear_table) {
		mapper.insertFear(fear_table);
	}

	@Override
	public void updateFear(Fear_Table fear_table) {
		mapper.updateFear(fear_table);
	}

	@Override
	public Fear_Table selectOneFear(String name) {
		return mapper.selectOneFear(name);
	}

}
