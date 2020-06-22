package com.face.facemaker.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.face.facemaker.model.dto.Anger_Table;
import com.face.facemaker.model.dto.Contempt_Table;
import com.face.facemaker.model.dto.Fear_Table;
import com.face.facemaker.model.dto.Happiness_Table;
import com.face.facemaker.model.dto.Neutral_Table;
import com.face.facemaker.model.dto.Sadness_Table;
import com.face.facemaker.model.dto.Surprise_Table;
import com.face.facemaker.model.service.AngerTableService;
import com.face.facemaker.model.service.ContemptTableService;
import com.face.facemaker.model.service.FearTableService;
import com.face.facemaker.model.service.HappinessTableService;
import com.face.facemaker.model.service.NeutralTableService;
import com.face.facemaker.model.service.SadnessTableService;
import com.face.facemaker.model.service.SurpriseTableService;
import com.face.facemaker.util.FaceUtil;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
public class FileUploadController2 {
	@Autowired
	NeutralTableService neutralService;
	@Autowired
	AngerTableService angerService;
	@Autowired
	ContemptTableService contemptService;
	@Autowired
	FearTableService fearService;
	@Autowired
	HappinessTableService happinessService;
	@Autowired
	SadnessTableService sadnessService;
	@Autowired
	SurpriseTableService surpriseService;
	

	@PostMapping(value = "/file/upload/{name}/{stage}")
	public void upload(@RequestPart MultipartFile mFile, @PathVariable String name, @PathVariable int stage) {
		Map<String, String> resultMap = new HashMap<>();
		try {
			String src = "C:\\Users\\ELIJAH\\Desktop\\FaceMaker_BACK\\FaceMaker\\src\\main\\webapp\\img\\" + name + "\\"
					+ mFile.getOriginalFilename();
			mFile.transferTo(new File(src));
			File file = new File(src);
			file.renameTo(new File("C:\\Users\\ELIJAH\\Desktop\\FaceMaker_BACK\\FaceMaker\\src\\main\\webapp\\img\\" + name + "\\"+Integer.toString(stage)+".jpg"));
			System.out.println(mFile.toString());
			resultMap.put("result", "success");

			// 초기화 작업 : name, src, stage
			init(name, src, stage);
			// 이미지 검출
			String jsonString = FaceUtil.detectFace(src);
			// 파싱작업
			parseFaceJSONData(jsonString, name, stage);

		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			resultMap.put("result", "fail");
		}
		// return resultMap;
	}

	public void parseFaceJSONData(String jsonString, String name, int stage) {
		JSONArray jarray = new JSONArray(jsonString);
		int person_cnt = jarray.length(); // 사람수

		JSONObject[] getFaceAttributes = new JSONObject[person_cnt];
		JSONObject[] getEmotion = new JSONObject[person_cnt];
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
			// System.out.println(getFaceAttributes[i]);
			getEmotion[i] = getFaceAttributes[i].getJSONObject("emotion");
			// System.out.println(getEmotion[i]);
			
			try {
				Age[i] = (Double) getFaceAttributes[i].get("age");
				Anger[i] = (Double) getEmotion[i].get("anger");
				Contempt[i] = (Double) getEmotion[i].get("contempt");
				Fear[i] = (Double) getEmotion[i].get("fear");
				Happiness[i] = (Double) getEmotion[i].get("happiness");
				Neutral[i] = (Double) getEmotion[i].get("neutral");
				Sadness[i] = (Double) getEmotion[i].get("sadness");
				Surprise[i] = (Double) getEmotion[i].get("surprise");
			}catch(Exception e) {
				Age[i] =  0.0;
				Anger[i] = 0.0;
				Contempt[i] = 0.0;
				Fear[i] = 0.0;
				Happiness[i] = 0.0;
				Neutral[i] = 0.0;
				Sadness[i] = 0.0;
				Surprise[i] = 0.0;
			
			}
		}

		// DB에 추가
		switch (stage) {
		case 1:
			Neutral_Table neutral_table = new Neutral_Table();
			neutral_table.setName(name);
			neutral_table.setAnger(Anger[0]);
			neutral_table.setContempt(Contempt[0]);
			neutral_table.setFear(Fear[0]);
			neutral_table.setHappiness(Happiness[0]);
			neutral_table.setNeutral(Neutral[0]);
			neutral_table.setSurprise(Surprise[0]);
			System.out.println(neutral_table);
			neutralService.updateNeutral(neutral_table);

			break;
		case 2:
			Anger_Table anger_table = new Anger_Table();
			anger_table.setName(name);
			anger_table.setAnger(Anger[0]);
			anger_table.setContempt(Contempt[0]);
			anger_table.setFear(Fear[0]);
			anger_table.setHappiness(Happiness[0]);
			anger_table.setNeutral(Neutral[0]);
			anger_table.setSurprise(Surprise[0]);
			System.out.println(anger_table);
			angerService.updateAnger(anger_table);

			break;
		case 3:
			Contempt_Table contempt_table = new Contempt_Table();
			contempt_table.setName(name);
			contempt_table.setAnger(Anger[0]);
			contempt_table.setContempt(Contempt[0]);
			contempt_table.setFear(Fear[0]);
			contempt_table.setHappiness(Happiness[0]);
			contempt_table.setNeutral(Neutral[0]);
			contempt_table.setSurprise(Surprise[0]);
			System.out.println(contempt_table);
			contemptService.updateContempt(contempt_table);

			break;
		case 4:
			Fear_Table fear_table = new Fear_Table();
			fear_table.setName(name);
			fear_table.setAnger(Anger[0]);
			fear_table.setContempt(Contempt[0]);
			fear_table.setFear(Fear[0]);
			fear_table.setHappiness(Happiness[0]);
			fear_table.setNeutral(Neutral[0]);
			fear_table.setSurprise(Surprise[0]);
			System.out.println(fear_table);
			fearService.updateFear(fear_table);

			break;
		case 5:
			Happiness_Table happiness_table = new Happiness_Table();
			happiness_table.setName(name);
			happiness_table.setAnger(Anger[0]);
			happiness_table.setContempt(Contempt[0]);
			happiness_table.setFear(Fear[0]);
			happiness_table.setHappiness(Happiness[0]);
			happiness_table.setNeutral(Neutral[0]);
			happiness_table.setSurprise(Surprise[0]);
			System.out.println(happiness_table);
			happinessService.updateHappiness(happiness_table);

			break;
		case 6:
			Sadness_Table sadness_table = new Sadness_Table();
			sadness_table.setName(name);
			sadness_table.setAnger(Anger[0]);
			sadness_table.setContempt(Contempt[0]);
			sadness_table.setFear(Fear[0]);
			sadness_table.setHappiness(Happiness[0]);
			sadness_table.setNeutral(Neutral[0]);
			sadness_table.setSurprise(Surprise[0]);
			System.out.println(sadness_table);
			sadnessService.updateSadness(sadness_table);

			break;
		case 7:
			Surprise_Table surprise_table = new Surprise_Table();
			surprise_table.setName(name);
			surprise_table.setAnger(Anger[0]);
			surprise_table.setContempt(Contempt[0]);
			surprise_table.setFear(Fear[0]);
			surprise_table.setHappiness(Happiness[0]);
			surprise_table.setNeutral(Neutral[0]);
			surprise_table.setSurprise(Surprise[0]);
			System.out.println(surprise_table);
			surpriseService.updateSurprise(surprise_table);

			break;

		default:
			break;
		}

	}

	public void init(String name, String src, int stage) {

		switch (stage) {
		case 1:
			Neutral_Table neutral_table = new Neutral_Table();
			neutral_table.setName(name);
			neutral_table.setSrc(src);
			neutral_table.setStage(1);
			neutralService.insertNeutral(neutral_table);
			break;
		case 2:
			Anger_Table anger_table = new Anger_Table();
			anger_table.setName(name);
			anger_table.setSrc(src);
			anger_table.setStage(stage);
			angerService.insertAnger(anger_table);
			break;
		case 3:
			Contempt_Table contempt_table = new Contempt_Table();
			contempt_table.setName(name);
			contempt_table.setSrc(src);
			contempt_table.setStage(stage);
			contemptService.insertContempt(contempt_table);
			break;
		case 4:
			Fear_Table fear_table = new Fear_Table();
			fear_table.setName(name);
			fear_table.setSrc(src);
			fear_table.setStage(stage);;
			fearService.insertFear(fear_table);
			break;
		case 5:
			Happiness_Table happiness_table = new Happiness_Table();
			happiness_table.setName(name);
			happiness_table.setSrc(src);
			happiness_table.setStage(stage);
			happinessService.insertHappiness(happiness_table);
			break;
		case 6:
			Sadness_Table sadness_table = new Sadness_Table();
			sadness_table.setName(name);
			sadness_table.setSrc(src);
			sadness_table.setStage(stage);
			sadnessService.insertSadness(sadness_table);
			break;
		case 7:
			Surprise_Table surprise_table = new Surprise_Table();
			surprise_table.setName(name);
			surprise_table.setSrc(src);
			surprise_table.setStage(stage);
			surpriseService.insertSurprise(surprise_table);
			break;

		default:
			break;
		}
		
	}
}
