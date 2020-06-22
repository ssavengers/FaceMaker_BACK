package com.face.facemaker.model.dao;

import com.face.facemaker.model.dto.Contempt_Table;

public interface ContemptTableDao {
	public void insertContempt(Contempt_Table contempt_table);//name, src, stage 추가
	public void updateContempt(Contempt_Table contempt_table);//감정 점수 추가
	public Contempt_Table selectOneContempt(String name);//한명의 감정 데이터 출력
	public void deleteContempt(String name);

}
