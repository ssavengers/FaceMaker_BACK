package com.face.facemaker.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.face.facemaker.model.service.AngerTableService;
import com.face.facemaker.model.service.ContemptTableService;
import com.face.facemaker.model.service.FearTableService;
import com.face.facemaker.model.service.HappinessTableService;
import com.face.facemaker.model.service.NeutralTableService;
import com.face.facemaker.model.service.SadnessTableService;
import com.face.facemaker.model.service.SurpriseTableService;
import com.face.facemaker.model.service.UserInfoService;

//Send emotion scores to web page
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
public class ScoreController {
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
	
	
	//Calculate scores & send them to web page 
	@GetMapping("/score/{name}")
	@ResponseBody
	public Map sendScore(@PathVariable String name) {
		Map map = new HashMap();
		int age = neutralService.selectOneNeutral(name).getAge();
		int neutral = (int) (neutralService.selectOneNeutral(name).getNeutral()*100);
		int anger = (int) (angerService.selectOneAnger(name).getAnger()*100);
		int contempt = (int) (contemptService.selectOneContempt(name).getContempt()*100);
		int fear = (int) (fearService.selectOneFear(name).getFear()*100);
		int happiness = (int) (happinessService.selectOneHappiness(name).getHappiness()*100);
		int sadness = (int) (sadnessService.selectOneSadness(name).getSadness()*100);
		int surprise = (int) (surpriseService.selectOneSurprise(name).getSurprise()*100);
		
		////////////// check emotion score //////////////
		System.out.println("age : "+age);
		System.out.println("neutral : "+neutral);
		System.out.println("anger : "+anger);
		System.out.println("contempt : "+contempt);
		System.out.println("fear : "+fear);
		System.out.println("happiness : "+happiness);
		System.out.println("sadness : "+sadness);
		System.out.println("surprise : "+surprise);
		//////////////////////////////////////////////////
		
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
	//delete image file, folder and db 
	public void delete(String name) {
		////get image src from db
		String neutral_src = neutralService.selectOneNeutral(name).getSrc();
		String anger_src = angerService.selectOneAnger(name).getSrc();
		String contempt_src = contemptService.selectOneContempt(name).getSrc();
		String fear_src = fearService.selectOneFear(name).getSrc();
		String happiness_src = happinessService.selectOneHappiness(name).getSrc();
		String sadness_src = sadnessService.selectOneSadness(name).getSrc();
		String surprise_src =surpriseService.selectOneSurprise(name).getSrc();
		String name_src = userinfoService.selectOneUserInfo(name).getSrc();
		
		////delete db
		neutralService.deleteNeutral(name);
		angerService.deleteAnger(name);
		contemptService.deleteContempt(name);
		fearService.deleteFear(name);
		happinessService.deleteHappiness(name);
		sadnessService.deleteSadness(name);
		surpriseService.deleteSurprise(name);
		userinfoService.deleteUserInfo(name);
		
		////delete image file and folder
		File neutral_image = new File(neutral_src);
		File anger_image = new File(anger_src);
		File contempt_image = new File(contempt_src);
		File fear_image = new File(fear_src);
		File happiness_image = new File(happiness_src);
		File sadness_image = new File(sadness_src);
		File surprise_image = new File(surprise_src);
		File name_folder = new File(name_src);
		
		neutral_image.delete();
		anger_image.delete();
		contempt_image.delete();
		fear_image.delete();
		happiness_image.delete();
		sadness_image.delete();
		surprise_image.delete();
		name_folder.delete();
		
	}
}
