package com.face.facemaker.model.dao;

import com.face.facemaker.model.dto.Fear_Table;

public interface FearTableDao {
	public void insertFear(Fear_Table fear_table);//name, src, stage 추가
	public void updateFear(Fear_Table fear_table);//감정 점수 추가
	public Fear_Table selectOneFear(String name);//한명의 감정 데이터 출력
	public void deleteFear(String name);

}
