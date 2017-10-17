package com.szczepaniak.nai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.szczepaniak.nai.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	public Person findByName(String name);
}
