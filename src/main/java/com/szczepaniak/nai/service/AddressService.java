package com.szczepaniak.nai.service;

import com.szczepaniak.nai.domain.Address;
import com.szczepaniak.nai.domain.Person;

public interface AddressService {
	
	public void addAddress(Person person, Address address);
	
	public void removeAddress(Long personId, Long addressId);
}
