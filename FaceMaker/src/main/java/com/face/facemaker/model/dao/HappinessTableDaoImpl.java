package com.face.facemaker.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.face.facemaker.mapper.HappinessTableMapper;
import com.face.facemaker.model.dto.Happiness_Table;
@Repository
public class HappinessTableDaoImpl implements HappinessTableDao {
	@Autowired
	HappinessTableMapper mapper;
	@Override
	public void insertHappiness(Happiness_Table happiness_table) {
		mapper.insertHappiness(happiness_table);
	}

	@Override
	public void updateHappiness(Happiness_Table happiness_table) {
		mapper.updateHappiness(happiness_table);
	}

	@Override
	public Happiness_Table selectOneHappiness(String name) {
		return mapper.selectOneHappiness(name);
	}

}
