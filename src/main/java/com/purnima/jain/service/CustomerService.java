package com.purnima.jain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.purnima.jain.domain.Customer;
import com.purnima.jain.entity.CustomerEntity;
import com.purnima.jain.repo.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public Customer getCustomerById(Integer customerId) {
		log.info("Inside the CustomerService::getCustomerById() for customerId :: {}", customerId);
		CustomerEntity customerEntity = customerRepository.findById(customerId).orElse(null);
		if(customerEntity == null)
			return null;
		Customer customer = new Customer(customerEntity.getCustomerId(), customerEntity.getFirstName(), customerEntity.getLastName());
		return customer;
	}

	public Customer saveCustomer(Customer customer) {
		log.info("Inside the CustomerService::saveCustomer() for customer :: {}", customer.toString());
		CustomerEntity customerEntity = new CustomerEntity(customer.getCustomerId(), customer.getFirstName(), customer.getLastName());
		customerEntity = customerRepository.save(customerEntity);
		
		Customer customerSaved = new Customer(customerEntity.getCustomerId(), customerEntity.getFirstName(), customerEntity.getLastName());
		
		return customerSaved;
	}

	public List<Customer> getAllCustomers() {
		log.info("Inside the CustomerService::getAllCustomers()................");
		List<CustomerEntity> customerEntityList = customerRepository.findAll();
		List<Customer> customerList = customerEntityList.stream().map(customerEntity -> new Customer(customerEntity.getCustomerId(), customerEntity.getFirstName(), customerEntity.getLastName())).collect(Collectors.toList());
		return customerList;
	}

	public Customer updateCustomer(Customer customer) {
		log.info("Inside the CustomerService::updateCustomer() for customer :: {}", customer.toString());
		
		CustomerEntity customerEntity = new CustomerEntity(customer.getCustomerId(), customer.getFirstName(), customer.getLastName());
		customerEntity = customerRepository.save(customerEntity);
		
		Customer customerUpdated = new Customer(customerEntity.getCustomerId(), customerEntity.getFirstName(), customerEntity.getLastName());
		
		return customerUpdated;
	}

	public void deleteCustomer(Integer customerId) {
		log.info("Inside the CustomerService::deleteCustomer() for customerId :: {}", customerId);
		customerRepository.deleteById(customerId);
	}
	
	

}
