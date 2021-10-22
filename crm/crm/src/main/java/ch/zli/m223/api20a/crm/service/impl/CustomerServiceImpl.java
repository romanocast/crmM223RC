package ch.zli.m223.api20a.crm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.api20a.crm.exception.CustomerNotFoundException;
import ch.zli.m223.api20a.crm.exception.InvalidParamException;
import ch.zli.m223.api20a.crm.model.Customer;
import ch.zli.m223.api20a.crm.model.impl.CustomerImpl;
import ch.zli.m223.api20a.crm.repository.CustomerRepository;
import ch.zli.m223.api20a.crm.repository.MemoRepository;
import ch.zli.m223.api20a.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired //Spring will inject the UserRepository
	private CustomerRepository customerRepository;
	
	@Autowired
	private MemoRepository memoRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return new ArrayList<>(customerRepository.findAll());
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
	}

	@Override
	public void deleteById(long id) {
		getCustomerById(id);//Parameter check
		customerRepository.deleteById(id);
	}

	@Override
	public Optional<CustomerImpl> getCustomerByName(String name) {
		return customerRepository.findCustomerByName(name);
	}

	@Override
	public Customer addCustomer(String name, String street, String city) {
		if (name == null || street == null || city == null) {
			throw new InvalidParamException();
		}
		return customerRepository.add(name, street, city);
	}

	@Override
	public Customer setMemosForCustomer(long id, String memos) {
		Customer customer = getCustomerById(id); //Parameter check
		if (memos == null) {
			throw new InvalidParamException();
		}
		
		return memoRepository.setMemos(customer, memos);
	}


}