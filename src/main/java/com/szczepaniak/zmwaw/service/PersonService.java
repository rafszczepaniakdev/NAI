package com.szczepaniak.zmwaw.service;

import java.util.List;

import com.szczepaniak.zmwaw.domain.Person;

public interface PersonService {
	public Person createPerson(Person person);
	
	public List<Person> getPersons(int page, int pageSize);
	
	public Person getPerson(Long id);
	
	public Person updatePerson(Person person);
	
	public void removePerson(Long id);
	
}
