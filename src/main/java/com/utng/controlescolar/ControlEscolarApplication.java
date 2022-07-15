package com.utng.controlescolar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
@ComponentScan("com.utng") //
public class ControlEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlEscolarApplication.class, args);
	}

}