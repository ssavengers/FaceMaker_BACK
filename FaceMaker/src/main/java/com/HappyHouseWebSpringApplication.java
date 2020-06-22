package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.face.facemaker.mapper"})
public class HappyHouseWebSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyHouseWebSpringApplication.class, args);
	}

}
