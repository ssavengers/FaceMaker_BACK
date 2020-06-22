package com.face.facemaker.model.dao;

import com.face.facemaker.model.dto.Happiness_Table;

public interface HappinessTableDao {
	public void insertHappiness(Happiness_Table happiness_table);//name, src, stage 추가
	public void updateHappiness(Happiness_Table happiness_table);//감정 점수 추가
	public Happiness_Table selectOneHappiness(String name);//한명의 감정 데이터 출력
	public void deleteHappiness(String name);

}
