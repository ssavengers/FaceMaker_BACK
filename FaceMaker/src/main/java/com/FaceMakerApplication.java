package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.face.facemaker.mapper"})
public class FaceMakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaceMakerApplication.class, args);
	}

}
