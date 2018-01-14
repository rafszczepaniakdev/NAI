package com.szczepaniak.nai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szczepaniak.nai.domain.Address;
import com.szczepaniak.nai.domain.Person;
import com.szczepaniak.nai.repository.AddressRepository;
import com.szczepaniak.nai.repository.PersonRepository;
import com.szczepaniak.nai.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public void addAddress(Person person, Address address) {
		address.setPerson(person);
		addressRepository.save(address);
//		person.getAddresses().add(address);
		
	}

	@Override
	public void removeAddress(Long personId, Long addressId) {
		Person p = personRepository.getOne(personId);
		if(p.getAddresses().size()>1)
			p.getAddresses().removeIf(a -> a.getId().equals(addressId));
		else
			p.getAddresses().clear();
		personRepository.save(p);
	}

}
