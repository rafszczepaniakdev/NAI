package com.szczepaniak.zmwaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.szczepaniak.zmwaw.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	

}
