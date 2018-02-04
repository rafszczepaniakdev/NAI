package com.szczepaniak.nai.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.szczepaniak.nai.domain.Country;
import com.szczepaniak.nai.domain.Person;
import com.szczepaniak.nai.dto.PersonDto;
import com.szczepaniak.nai.repository.PersonRepository;
import com.szczepaniak.nai.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getPersons(ModelAndView mav) {
		List<Person> persons = personService.getPersons(0, 10);
		List<PersonDto> dtoPersons = persons.stream().map(p -> convertToDto(p)).collect(Collectors.toList());
		mav.setViewName("person");
		mav.addObject("persons", dtoPersons);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getPerson(@PathVariable("id") Long id, ModelAndView mav) {
		Person person = personService.getPerson(id);
		mav.setViewName("editPerson");
		mav.addObject("person", convertToDto(person));
		return mav;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView updatePerson(@ModelAttribute PersonDto personDto, ModelAndView mav) {
		Person person = convertToEntity(personDto);
		personService.updatePerson(person);
		List<Person> persons = personService.getPersons(0, 10);
		List<PersonDto> dtoPersons = persons.stream().map(p -> convertToDto(p)).collect(Collectors.toList());
		mav.setViewName("person");
		mav.addObject("persons", dtoPersons);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView createPerson(@ModelAttribute PersonDto personDto, ModelAndView mav) {
		personService.createPerson(convertToEntity(personDto));
		List<Person> persons = personService.getPersons(0, 10);
		persons.stream().map(p -> convertToDto(p)).collect(Collectors.toList());
		mav.setViewName("person");
		mav.addObject("persons", persons);
		return mav;
	}

	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ModelAndView deletePerson(@RequestParam(value = "id", required = true) Long id, ModelAndView mav) {
		personService.removePerson(id);
		List<Person> persons = personService.getPersons(0, 10);
		persons.stream().map(p -> convertToDto(p)).collect(Collectors.toList());
		mav.setViewName("person");
		mav.addObject("persons", persons);
		return mav;
	}

	public PersonDto convertToDto(Person person) {
		return modelMapper.map(person, PersonDto.class);
	}

	private Person convertToEntity(PersonDto personDto) throws ParseException {
		return modelMapper.map(personDto, Person.class);
	}

}
