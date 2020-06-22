package com.face.facemaker.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.face.facemaker.mapper.AngerTableMapper;
import com.face.facemaker.model.dto.Anger_Table;
@Repository
public class AngerTableDaoImpl implements AngerTableDao {
	@Autowired
	AngerTableMapper mapper;
	
	@Override
	public void insertAnger(Anger_Table anger_table) {
		mapper.insertAnger(anger_table);
	}

	@Override
	public void updateAnger(Anger_Table anger_table) {
		mapper.updateAnger(anger_table);
	}

	@Override
	public Anger_Table selectOneAnger(String name) {
		return mapper.selectOneAnger(name);
	}

	@Override
	public void deleteAnger(String name) {
		mapper.deleteAnger(name);
	}

}
