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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.face.facemaker.model.service.UserInfoService;
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
	@Autowired
	UserInfoService userinfoService;
	
	
	//총 계산
	@GetMapping("/score/{name}")
	@ResponseBody
	public Map sendScore(@PathVariable String name) {
		Map map = new HashMap();
		int age = neutralService.selectOneNeutral(name).getAge();
		int neutral = (int) (neutralService.selectOneNeutral(name).getNeutral()*100);
		int anger = (int) (100*angerService.selectOneAnger(name).getAnger());
		int contempt = (int) (100*contemptService.selectOneContempt(name).getContempt());
		int fear = (int) (fearService.selectOneFear(name).getFear()*100);
		int happiness = (int) (happinessService.selectOneHappiness(name).getHappiness()*100);
		int sadness = (int) (sadnessService.selectOneSadness(name).getSadness()*100);
		int surprise = (int) (surpriseService.selectOneSurprise(name).getSurprise()*100);
		
		//System.out.println("age : "+age);
		System.out.println("neutral : "+neutral);
		System.out.println("anger : "+anger);
		System.out.println("contempt : "+contempt);
		System.out.println("fear : "+fear);
		System.out.println("happiness : "+happiness);
		System.out.println("sadness : "+sadness);
		System.out.println("surprise : "+surprise);
		
		delete(name);
		
		map.put("age", age);
		map.put("neutral", neutral);
		map.put("anger", anger);
		map.put("contempt", contempt);
		map.put("fear", fear);
		map.put("happiness", happiness);
		map.put("sadness", sadness);
		map.put("surprise", surprise);
		
		return map;
	}
	//이미지 파일 폴더와 db삭제
	public void delete(String name) {
		//db로 부터 이미지 경로 받아오기
		String neutral_src = neutralService.selectOneNeutral(name).getSrc();
		String anger_src = angerService.selectOneAnger(name).getSrc();
		String contempt_src = contemptService.selectOneContempt(name).getSrc();
		String fear_src = fearService.selectOneFear(name).getSrc();
		String happiness_src = happinessService.selectOneHappiness(name).getSrc();
		String sadness_src = sadnessService.selectOneSadness(name).getSrc();
		String surprise_src =surpriseService.selectOneSurprise(name).getSrc();
		String name_src = userinfoService.selectOneUserInfo(name).getSrc();
		
		
		File neutral_image = new File(neutral_src);
		File anger_image = new File(anger_src);
		File contempt_image = new File(contempt_src);
		File fear_image = new File(fear_src);
		File happiness_image = new File(happiness_src);
		File sadness_image = new File(sadness_src);
		File surprise_image = new File(surprise_src);
		File name_folder = new File(name_src);
		
		
		//db삭제
		neutralService.deleteNeutral(name);
		angerService.deleteAnger(name);
		contemptService.deleteContempt(name);
		fearService.deleteFear(name);
		happinessService.deleteHappiness(name);
		sadnessService.deleteSadness(name);
		surpriseService.deleteSurprise(name);
		userinfoService.deleteUserInfo(name);
		
		//이미지 및 폴더 삭제
		neutral_image.delete();
		anger_image.delete();
		contempt_image.delete();
		fear_image.delete();
		happiness_image.delete();
		sadness_image.delete();
		surprise_image.delete();
		name_folder.delete();
		
		
	}

	@PostMapping(value = "/file/upload/{name}/{stage}")
	public void upload(@RequestPart MultipartFile mFile, @PathVariable String name, @PathVariable int stage) {
		Map<String, String> resultMap = new HashMap<>();
		try {
			String src = "C:\\Users\\ELIJAH\\Desktop\\FaceMaker_BACK\\FaceMaker\\src\\main\\webapp\\img\\" + name + "\\"
					+ mFile.getOriginalFilename();
			mFile.transferTo(new File(src));
			File file = new File(src);
			//////이미 파일이 있는지 확인//////
			File checkFile = new File("C:\\Users\\ELIJAH\\Desktop\\FaceMaker_BACK\\FaceMaker\\src\\main\\webapp\\img\\" + name + "\\"+Integer.toString(stage)+".jpg");
			if(checkFile.exists()) {
				checkFile.delete();
			}
			/////////////////////////
			file.renameTo(new File("C:\\Users\\ELIJAH\\Desktop\\FaceMaker_BACK\\FaceMaker\\src\\main\\webapp\\img\\" + name + "\\"+Integer.toString(stage)+".jpg"));
			src = "C:\\Users\\ELIJAH\\Desktop\\FaceMaker_BACK\\FaceMaker\\src\\main\\webapp\\img\\" + name + "\\"+Integer.toString(stage)+".jpg";
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
		
		//neutral 
		switch (stage) {
		case 1:
			Neutral_Table neutral_table = new Neutral_Table();
			neutral_table.setName(name);
			double d_age = Age[0];
			int age = (int) d_age;
			neutral_table.setAge(age);
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
		case 3:
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
		case 4:
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
		case 5:
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
		case 6:
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
		case 7:
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
			Happiness_Table happiness_table = new Happiness_Table();
			happiness_table.setName(name);
			happiness_table.setSrc(src);
			happiness_table.setStage(stage);
			happinessService.insertHappiness(happiness_table);
			break;
		case 3:
			Sadness_Table sadness_table = new Sadness_Table();
			sadness_table.setName(name);
			sadness_table.setSrc(src);
			sadness_table.setStage(stage);
			sadnessService.insertSadness(sadness_table);
			break;
		case 4:
			Anger_Table anger_table = new Anger_Table();
			anger_table.setName(name);
			anger_table.setSrc(src);
			anger_table.setStage(stage);
			angerService.insertAnger(anger_table);
			break;
		case 5:
			Contempt_Table contempt_table = new Contempt_Table();
			contempt_table.setName(name);
			contempt_table.setSrc(src);
			contempt_table.setStage(stage);
			contemptService.insertContempt(contempt_table);
			break;
		case 6:
			Surprise_Table surprise_table = new Surprise_Table();
			surprise_table.setName(name);
			surprise_table.setSrc(src);
			surprise_table.setStage(stage);
			surpriseService.insertSurprise(surprise_table);
			break;
		case 7:
			Fear_Table fear_table = new Fear_Table();
			fear_table.setName(name);
			fear_table.setSrc(src);
			fear_table.setStage(stage);;
			fearService.insertFear(fear_table);
			break;

		default:
			break;
		}
		
	}
}
