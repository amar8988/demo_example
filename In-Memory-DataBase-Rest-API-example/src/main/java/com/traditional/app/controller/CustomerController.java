package com.traditional.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traditional.app.entity.Customer;
import com.traditional.app.service.CustomerService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {

	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);

	}

	@PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Customer>> saveCustomers(@RequestBody List<Customer> customers) {

		return new ResponseEntity<>(customerService.saveCustomers(customers), HttpStatus.OK);

	}

	@PutMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);

	}

	@GetMapping(value = "/customers")
	public ResponseEntity<List<Customer>> findAllCustomers() {

		return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);

	}

	@GetMapping(value = "/customer/{customerId}")
	public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable Long customerId) {

		return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);

	}

	@GetMapping(value = "/customer/byName")
	public ResponseEntity<List<Customer>> findCustomerById(@RequestParam String customerName) {

		return new ResponseEntity<>(customerService.getCustomer(customerName), HttpStatus.OK);

	}

	@DeleteMapping(value = "/customer/{customerId}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable Long customerId) {

		return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);

	}

}
