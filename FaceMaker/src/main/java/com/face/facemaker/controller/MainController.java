package com.face.facemaker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.face.facemaker.model.dto.Neutral_Table;
import com.face.facemaker.model.service.NeutralTableService;
import com.face.facemaker.util.FaceUtil;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class MainController {
	@Autowired
 	NeutralTableService neutralService;
	
	//////////// Test//////////////////
	// 초기설정: name, src, stage
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public Neutral_Table insertImage() {
		String name = UserinfoController.name;
		String src = UserinfoController.path + "salah.JPG";
		
		
		System.out.println("test");
		if(name!=null) {
			int stage = 1;// 1단계
			Neutral_Table neutral_table = new Neutral_Table();
			neutral_table.setName(name);
			neutral_table.setSrc(src);;
			neutral_table.setStage(stage);
			neutralService.insertNeutral(neutral_table);
			
			//이미지 감식
			String jsonString = FaceUtil.detectFace(src);
			System.out.println(jsonString);
			if(jsonString!="") {
				 	//JSONParser jsonParser = new JSONParser();

		            JSONArray jarray = new JSONArray(jsonString);
		            int person_cnt = jarray.length(); //사람수

		            JSONObject[] getFaceAttributes = new JSONObject[person_cnt];
		            JSONObject[] getEmotion = new JSONObject[person_cnt];
		            JSONObject[] getAge = new JSONObject[person_cnt];
		            Double[] Age = new Double[person_cnt];
		            Double[] Anger = new Double[person_cnt];
		            Double[] Contempt = new Double[person_cnt];
		            Double[] Fear = new Double[person_cnt];
		            Double[] Happiness = new Double[person_cnt];
		            Double[] Neutral = new Double[person_cnt];
		            Double[] Sadness = new Double[person_cnt];
		            Double[] Surprise = new Double[person_cnt];

		            for (int i = 0; i < person_cnt; i++) {
		               JSONObject jsonobject = jarray.getJSONObject(i);
		               getFaceAttributes[i] = jsonobject.getJSONObject("faceAttributes");
		               //System.out.println(getFaceAttributes[i]);
		               getEmotion[i] = getFaceAttributes[i].getJSONObject("emotion");
		               //System.out.println(getEmotion[i]);
		               
		               Age[i] = (Double)getFaceAttributes[i].get("age");
		               Anger[i] = (Double)getEmotion[i].get("anger");
		               Contempt[i] = (Double)getEmotion[i].get("contempt");
		               Fear[i] = (Double)getEmotion[i].get("fear");
		               Happiness[i] = (Double)getEmotion[i].get("happiness");
		               Neutral[i] = (Double)getEmotion[i].get("neutral");
		               Sadness[i] = (Double)getEmotion[i].get("sadness");
		               Surprise[i] = (Double)getEmotion[i].get("surprise");

		           }
		           neutral_table.setAnger(Anger[0]);
		           neutral_table.setContempt(Contempt[0]);;
		           neutral_table.setFear(Fear[0]);
		           neutral_table.setHappiness(Happiness[0]);
		           neutral_table.setNeutral(Neutral[0]);
		           neutral_table.setSadness(Sadness[0]);
		           neutral_table.setSurprise(Surprise[0]);
		           
		           neutralService.updateNeutral(neutral_table);
		           
		           
		    }
		}
		return neutralService.selectOneNeutral(name);
	}
	/////////////////////////////////

}
