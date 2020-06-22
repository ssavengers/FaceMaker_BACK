package com.face.facemaker.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
public class FileDownloadController {
	@GetMapping(value = "/file/download/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType() throws IOException {
		InputStream in = getClass().getResourceAsStream("C://Users//ELIJAH//Desktop//FaceMaker_BACK//FaceMaker//src//main//webapp//img//kang//15926696773172352409165904840840.jpg");
		return IOUtils.toByteArray(in);
	}
}
