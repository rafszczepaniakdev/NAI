package com.szczepaniak.zmwaw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.szczepaniak.zmwaw.domain.Person;
import com.szczepaniak.zmwaw.repository.PersonRepository;
import com.szczepaniak.zmwaw.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person getPerson(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public List<Person> getPersons(int page, int pageSize) {
		PageRequest pageRequest = new PageRequest(page, pageSize);
		Page<Person> pages = personRepository.findAll(pageRequest);
		return pages.getContent();
	}

	@Override
	public Person updatePerson(Person person) {
		Person oldPerson = personRepository.findOne(person.getId());
		oldPerson.setName(person.getName());
		return personRepository.save(oldPerson);
	}

	@Override
	public void removePerson(Long id) {
		personRepository.delete(id);
	}

}
