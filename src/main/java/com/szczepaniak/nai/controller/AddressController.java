package com.szczepaniak.nai.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.szczepaniak.nai.domain.Address;
import com.szczepaniak.nai.domain.Person;
import com.szczepaniak.nai.dto.AddressDto;
import com.szczepaniak.nai.dto.PersonDto;
import com.szczepaniak.nai.service.AddressService;
import com.szczepaniak.nai.service.PersonService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private PersonService personService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ModelAndView addAddress(@PathVariable("id") Long id, @ModelAttribute AddressDto addressDto, ModelAndView mav) {
		Person person = personService.getPerson(id);
		Address address = convertAddressToEntity(addressDto);
		addressService.addAddress(person, address);
		return new ModelAndView("redirect:/person/"+id);
	}

	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ModelAndView deleteAddress(@RequestParam(value = "addressId", required = true) Long addressId,
			@RequestParam(value = "personId", required = true) Long personId, ModelAndView mav) {
		addressService.removeAddress(personId, addressId);
		return new ModelAndView("redirect:/person/"+personId);
	}

	public PersonDto convertToDto(Person person) {
		return modelMapper.map(person, PersonDto.class);
	}
	
	private Address convertAddressToEntity(AddressDto addressDto) throws ParseException {
		return modelMapper.map(addressDto, Address.class);
	}

}
