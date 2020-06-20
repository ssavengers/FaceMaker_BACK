package com.face.facemaker.model.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.face.facemaker.mapper.FileUploadMapper;

@Service
public class FileUploadService {
    
    private String uploadPath = "C:\\Users\\ELIJAH\\Desktop\\FaceMaker_BACK\\FaceMaker\\src\\main\\webapp\\img";
    
    @Autowired
    private FileUploadMapper mapper;
    
    
    public boolean uploadFile(MultipartFile[] uploadFiles) throws IOException {
        
        Map<String,Object>fileMap=new HashMap<String,Object>();
        for(MultipartFile multipartFile : uploadFiles) {
            try {
                String fileName=generateFileName(multipartFile);
                System.out.println(fileName);
                File tmp=new File(uploadPath+fileName);
                
                fileMap.put("fileName", fileName);
                fileMap.put("fileSize", multipartFile.getSize());
                System.out.println("fileMap :"+fileMap);
                multipartFile.transferTo(tmp);
                mapper.insertFiles(fileMap);
            }
            catch(Exception e){
                return false;
            }
    }
        return true;
 
}
    
    private String generateFileName(MultipartFile multipartFile) {
        Calendar cal=Calendar.getInstance();
        Date date=cal.getTime();
        String fileName=new SimpleDateFormat("yyyyMMdd").format(date)+"_"+multipartFile.getOriginalFilename();
        return fileName;
    }
}
