package com.avisys.cim.service;

import java.util.List;

import com.avisys.cim.Customer;
import com.avisys.cim.payload.CustomerDto;

public interface CustomerService {
	List<CustomerDto> getAllCustomers();
	
	CustomerDto getCustomer(String mobNo);
	
	
	List<CustomerDto> searchFirstName(String keyword);
	
	List<CustomerDto> searchLastName(String keyword);
	
	List<CustomerDto> searchName(String keyword);

	
	
	CustomerDto createCustomer(CustomerDto cDto) throws com.avisys.cim.exceptionss.DuplicateMobileNumberException;
	
	CustomerDto addMobileNumber(Long id, String mobileNumber) throws com.avisys.cim.exceptionss.DuplicateMobileNumberException;
	
	public void deleteCustomer(String mobileNumber);
	
	public void deleteMobileNo(long id, String mobileNumber);
}
