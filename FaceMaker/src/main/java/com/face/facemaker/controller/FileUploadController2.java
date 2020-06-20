package com.face.facemaker.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
public class FileUploadController2 {
//	@RequestMapping("/file/upload")
//	public void upload(HttpServletRequest request,@RequestPart MultipartFile mFile) {
//		try {
//			mFile.transferTo(new File("C:\\Users\\ELIJAH\\Desktop\\"+mFile.getOriginalFilename()));
//			System.out.println(mFile.toString());
//		}catch(IllegalStateException | IOException e) {
//			e.printStackTrace();
//		}
//	}
	@PostMapping(value="/file/upload/{name}")
	@ResponseBody
	public Map<String,String> upload(@RequestPart MultipartFile mFile,@PathVariable String name) {
		Map<String, String> resultMap = new HashMap<>();
		try {
			mFile.transferTo(new File("C:\\Users\\ELIJAH\\Desktop\\"+name+"\\"+mFile.getOriginalFilename()));
			System.out.println(mFile.toString());
			resultMap.put("result", "success");
		}catch(IllegalStateException | IOException e) {
			e.printStackTrace();
		     resultMap.put("result", "fail");
		}
		return resultMap;
	}
}
