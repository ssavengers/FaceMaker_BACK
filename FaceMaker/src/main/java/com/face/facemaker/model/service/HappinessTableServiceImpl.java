package com.face.facemaker.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.face.facemaker.model.dao.HappinessTableDao;
import com.face.facemaker.model.dto.Happiness_Table;
@Service
public class HappinessTableServiceImpl implements HappinessTableService {
	@Autowired
	HappinessTableDao dao;
	@Override
	public void insertHappiness(Happiness_Table happiness_table) {
		dao.insertHappiness(happiness_table);
	}

	@Override
	public void updateHappiness(Happiness_Table happiness_table) {
		dao.updateHappiness(happiness_table);
	}

	@Override
	public Happiness_Table selectOneHappiness(String name) {
		return dao.selectOneHappiness(name);
	}

	@Override
	public void deleteHappiness(String name) {
		dao.deleteHappiness(name);
	}

}
