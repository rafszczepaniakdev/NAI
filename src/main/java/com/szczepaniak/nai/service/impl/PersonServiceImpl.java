package com.szczepaniak.nai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.szczepaniak.nai.domain.Person;
import com.szczepaniak.nai.repository.PersonRepository;
import com.szczepaniak.nai.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person createPerson(Person person) {
		person.getAddresses().forEach(a->a.setPerson(person));
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
		oldPerson.getAddresses().clear();
		oldPerson.getAddresses().addAll(person.getAddresses());
		oldPerson.getAddresses().forEach(a->a.setPerson(person));
		return personRepository.save(oldPerson);
	}

	@Override
	public void removePerson(Long id) {
		personRepository.delete(id);
	}

}
