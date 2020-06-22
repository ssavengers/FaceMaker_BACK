package com.face.facemaker.model.service;

import com.face.facemaker.model.dto.Anger_Table;

public interface AngerTableService {
	public void insertAnger(Anger_Table anger_table);//name, src, stage 추가
	public void updateAnger(Anger_Table anger_table);//감정 점수 추가
	public Anger_Table selectOneAnger(String name);//한명의 감정 데이터 출력

}
