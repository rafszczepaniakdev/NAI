package com.szczepaniak.nai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.szczepaniak.nai.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
