package com.face.facemaker.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.face.facemaker.model.dto.UserInfo;
import com.face.facemaker.model.service.UserInfoService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
public class UserinfoController {
	@Autowired
	UserInfoService service;
	
	static String path= "./src/main/webapp/img/";
	
	public void makeDirectory(String name, int age, String newPath) {
		//////////// static의 img 폴더에 해당 id를 이름으로 가지는 디렉토리 생성/////////////////////
		File newFolder = new File(newPath);

		// 해당 디렉토리가 없을 경우 디렉토리를 생성
		if (!newFolder.exists()) {
			try {
				newFolder.mkdir();// 폴더 생성
				System.out.println("폴더 생성 완료");
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			System.out.println("이미 해당 폴더가 있음");
		}
		////////////////////////////////////////////////////////////////
	}

	@RequestMapping(value = "/login/{name}/{age}", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map login(@PathVariable String name, @PathVariable int age) {
		System.out.println("LOGIN PROCESS");
		System.out.println("name:" + name + ",age:" + age);
		String src = path + name;
		makeDirectory(name,age,src);
		UserInfo userinfo = new UserInfo();
		userinfo.setAge(age);
		userinfo.setName(name);
		userinfo.setSrc(src);
		service.addUserInfo(userinfo);
	
		Map map = new HashMap();
		map.put("result", "success");
		return map;
	}

}