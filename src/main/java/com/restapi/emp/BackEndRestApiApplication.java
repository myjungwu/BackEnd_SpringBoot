package com.restapi.emp;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackEndRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndRestApiApplication.class, args);
	}


	//Jackson Datatype Hibernate의 Hibernate6Module 객체를 Spring Bean으로 등록하고, 강제 지연로딩 설정
	@Bean
	Hibernate6Module hibernate6Module() {
		Hibernate6Module hibernate6Module = new Hibernate6Module();
		hibernate6Module.configure(Hibernate6Module.Feature.FORCE_LAZY_LOADING,true);
		return hibernate6Module;
	}
}
