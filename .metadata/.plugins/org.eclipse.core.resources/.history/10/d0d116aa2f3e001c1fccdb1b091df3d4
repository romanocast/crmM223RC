package ch.zli.m223.api20a.crm.controller.rest.dto;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.api20a.crm.model.Customer;
import ch.zli.m223.api20a.crm.model.Memo;

public class CustomerDto {
	public Long id;
	public String name;
	public String street;
	public String city;
	public List<Memo> memos = new ArrayList<>();
	
	public CustomerDto(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.street = customer.getStreet();
		this.city = customer.getCity();
		memos.addAll(customer.getMemos());
	}
}
