package com.face.facemaker.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.face.facemaker.model.service.FileUploadService;

@RestController

public class FileUploadController {
    @Autowired
    FileUploadService serviceFile;
    
    @PostMapping("/file/upload")
    @ResponseBody
    public Map<String,Object> uploadFiles(MultipartFile[] uploadFiles) throws IOException{
    
        Map<String,Object> resultMap=new HashMap<String,Object>();
        
        boolean fileUpload=serviceFile.uploadFile(uploadFiles);
        
        if(fileUpload) {
            resultMap.put("result", "success");
        }else {
            resultMap.put("result", "fail");
        }
        
        return resultMap;
        
    }
}