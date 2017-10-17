package com.szczepaniak.nai.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.szczepaniak.nai.domain.Person;
import com.szczepaniak.nai.repository.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(value = "/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping("/add")
	public String addPerson(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "birthDate", required = true) String birthDate, Model model) {
		Person person = new Person();
		person.setName(name);
		LocalDate birth = LocalDate.parse(birthDate);
		person.setBirthDate(birth);
		model.addAttribute("person", personRepository.save(person));
		return "addedPerson";
	}
	
	@RequestMapping("/get")
	public String addPerson(@RequestParam(value = "id", required = true) Long id, Model model) {
		model.addAttribute("person", personRepository.findOne(id));
		return "getPerson";
	}

}
