package com.face.facemaker.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.face.facemaker.model.dto.UserInfo;
import com.face.facemaker.model.service.UserInfoService;

@Controller
public class UserinfoController {
	@Autowired
	UserInfoService service;
	
	public void makeDirectory(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
		String name = userinfo.getName();
		System.out.println(name);
		////////////static의 img 폴더에 해당 id를 이름으로 가지는 디렉토리 생성/////////////////////
		String newPath = "./src/main/webapp/img/"+name;
	    File newFolder = new File(newPath);
	    
	    //해당 디렉토리가 없을 경우 디렉토리를 생성
	    if(!newFolder.exists()) {
	    	try {
	    		newFolder.mkdir();//폴더 생성
	    		System.out.println("폴더 생성 완료");
	    	}catch(Exception e){
	    		e.getStackTrace();
	    	}
	    }else {
	    	System.out.println("이미 해당 폴더가 있음");
	    }
	    ////////////////////////////////////////////////////////////////
	}
	
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String path = "index";
		try {
			UserInfo userinfo = service.login(name, age);
			if (userinfo != null) {
				// session 설정
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", userinfo);
				makeDirectory(request);
			
			} else {
				// request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
				model.addAttribute("msg", "닉네임 또는 나이를 확인 후 로그인해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// request.setAttribute("msg", "로그인 중 문제가 발생했습니다.");
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			path = "error";
		}
		return path;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("userinfo", null);
		return "index";
	}
	
	//회원가입 창으로 이동
	@GetMapping("/joinForm")
	public String movejoin(HttpServletRequest request) {
		return "join";
	}
	
	@PostMapping("/join")
	public String join(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		UserInfo userinfo = new UserInfo();
		userinfo.setName(name);
		userinfo.setAge(age);
		service.addUserInfo(userinfo);
	
		return "index";
	}
}
