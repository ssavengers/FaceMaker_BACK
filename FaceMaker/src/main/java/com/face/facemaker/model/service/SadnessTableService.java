package com.face.facemaker.model.service;

import com.face.facemaker.model.dto.Sadness_Table;

public interface SadnessTableService {
	public void insertSadness(Sadness_Table sadness_table);//name, src, stage 추가
	public void updateSadness(Sadness_Table sadness_table);//감정 점수 추가
	public Sadness_Table selectOneSadness(String name);//한명의 감정 데이터 출력

}
