package com.face.facemaker.model.dao;

import com.face.facemaker.model.dto.Surprise_Table;

public interface SurpriseTableDao {
	public void insertSurprise(Surprise_Table surprise_table);//name, src, stage 추가
	public void updateSurprise(Surprise_Table surprise_table);//감정 점수 추가
	public Surprise_Table selectOneSurprise(String name);//한명의 감정 데이터 출력

}
