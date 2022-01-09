package com.groupe10.GestionEmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GestionEmpApplication {

	public static void main(String[] args) {
		org.springframework.context.ConfigurableApplicationContext
				run = SpringApplication.run(GestionEmpApplication.class, args);

	}

}
