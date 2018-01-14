package com.szczepaniak.nai.dto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PersonDto {
	private Long id;
	private String name;
	private List<AddressDto> addresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AddressDto> getAddresses() {
		return Optional.ofNullable(addresses).orElseGet(Collections::emptyList);
	}

	public void setAddresses(List<AddressDto> addresses) {
		this.addresses = addresses;
	}

}
