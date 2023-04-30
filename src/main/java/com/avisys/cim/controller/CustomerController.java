package com.avisys.cim.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.exceptionss.DuplicateMobileNumberException;
import com.avisys.cim.payload.CustomerDto;
import com.avisys.cim.repository.CustomerRepo;
import com.avisys.cim.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController { // CONTROLLER layer

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{mobileNo}") // Search customers by Mobile No
	public ResponseEntity<CustomerDto> getUserByMobileNo(@PathVariable String mobileNo) {
		CustomerDto customerDto = this.customerService.getCustomer(mobileNo);
		return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CustomerDto>> getAllResources() { // fetch all customers

		List<CustomerDto> allCustomers = this.customerService.getAllCustomers();
		return new ResponseEntity<List<CustomerDto>>(allCustomers, HttpStatus.OK);
	}

	@GetMapping("/search/firstName/{keywords}") // Search Customer by first Name
	public ResponseEntity<List<CustomerDto>> searchFirstName(@PathVariable("keywords") String keywords) {
		List<CustomerDto> result = this.customerService.searchFirstName(keywords);
		return new ResponseEntity<List<CustomerDto>>(result, HttpStatus.OK);

	}

	@GetMapping("/search/lastName/{keywords}") // Search Customer by Last Name
	public ResponseEntity<List<CustomerDto>> searchLastName(@PathVariable("keywords") String keywords) {
		List<CustomerDto> result = this.customerService.searchLastName(keywords);
		return new ResponseEntity<List<CustomerDto>>(result, HttpStatus.OK);

	}

	@GetMapping("/search/Name/{keywords}") // Search Customer by either First Name or Last Name
	public ResponseEntity<List<CustomerDto>> searchName(@PathVariable("keywords") String keywords) {
		List<CustomerDto> result = this.customerService.searchName(keywords);
		return new ResponseEntity<List<CustomerDto>>(result, HttpStatus.OK);

	}

  //*****************************************************************
	
	// Task 2
	
	// Create Customer when mobile number is unique
	
		@PostMapping("/")
		public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto cDto)
				throws com.avisys.cim.exceptionss.DuplicateMobileNumberException {
			CustomerDto customerDto = this.customerService.createCustomer(cDto);
			return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.CREATED);
		}
	
  // *********************************************************************
		
    // Task 3
		
		//Update customer with multiple mobile number
		
		@PutMapping("/mobileNo/{id}/{mobileNumber}")
		public ResponseEntity<CustomerDto> addMobileNumber(@PathVariable long id, @PathVariable String mobileNumber) throws DuplicateMobileNumberException{

			CustomerDto updatedCustomer = customerService.addMobileNumber(id, mobileNumber);
			return new ResponseEntity<CustomerDto>(updatedCustomer, HttpStatus.OK);

		}

}
