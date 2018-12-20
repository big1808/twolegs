package com.tedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.tedu.dao"})
public class TwolegsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwolegsApplication.class, args);
	}

}

