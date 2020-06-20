package com.face.facemaker.controller;

import java.io.File;

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

import com.face.facemaker.model.dto.UserInfo;
import com.face.facemaker.model.service.UserInfoService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
public class UserinfoController {
	@Autowired
	UserInfoService service;
	
	static String name = "test3";
	static int age = 20;
	static String path= "./src/main/webapp/img/";
	
	public void makeDirectory(String name) {
		//////////// static의 img 폴더에 해당 id를 이름으로 가지는 디렉토리 생성/////////////////////
		String newPath = path + name;
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
	public void login(@PathVariable String name, @PathVariable int age) {
		System.out.println("LOGIN PROCESS");
		System.out.println("name:" + name + ",age:" + age);

		makeDirectory(name);

	}

	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("userinfo", null);
		return "index";
	}

	// 회원가입 창으로 이동
	@GetMapping("/joinForm")
	public String movejoin(HttpServletRequest request) {
		return "join";
	}

	@PostMapping("/join")
	public String join(HttpServletRequest request) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		UserInfo userinfo = new UserInfo();
		userinfo.setName(name);
		userinfo.setAge(age);
		service.addUserInfo(userinfo);

		return "index";
	}

}