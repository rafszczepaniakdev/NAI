package com.szczepaniak.zmwaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.szczepaniak.zmwaw.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	public Person findByName(String name);
}
