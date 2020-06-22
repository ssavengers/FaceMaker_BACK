package com.face.facemaker.model.service;

import com.face.facemaker.model.dto.Neutral_Table;

public interface NeutralTableService {
	public void insertNeutral(Neutral_Table neutral_table);//name, src, stage 추가
	public void updateNeutral(Neutral_Table neutral_table);//감정 점수 추가
	public Neutral_Table selectOneNeutral(String name);//한명의 감정 데이터 출력
	public void deleteNeutral(String name);

}
