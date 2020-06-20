package com.face.facemaker.mapper;

import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadMapper {
	public void insertFiles(Map<String, Object> fileMap);
	public boolean uploadFilse(MultipartFile[] uploadFiles);
}
