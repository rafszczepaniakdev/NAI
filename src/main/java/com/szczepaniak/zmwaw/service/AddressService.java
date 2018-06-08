package com.szczepaniak.zmwaw.service;

import com.szczepaniak.zmwaw.domain.Address;
import com.szczepaniak.zmwaw.domain.Person;

public interface AddressService {
	
	public void addAddress(Person person, Address address);
	
	public void removeAddress(Long personId, Long addressId);
}
