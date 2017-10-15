package com.szczepaniak.nai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

	@RequestMapping("/")
	public String greeting() {
		return "Greetings from Spring Boot!";
	}

}
