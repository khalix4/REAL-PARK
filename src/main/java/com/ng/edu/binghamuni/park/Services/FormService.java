package com.ng.edu.binghamuni.park.Services;

import com.ng.edu.binghamuni.park.Domain.CustomerInformation;
import org.springframework.stereotype.Service;


import java.util.List;

public interface FormService {
    CustomerInformation saveCustomer(CustomerInformation customerInformation);
    long getTotalWebAddSourceCount();
    long getTotalNewspaperSourceCount();
    long getTotalWordOfMouthSourceCount();
    long getTotalCustomers();

CustomerInformation getCustomerbyId(long id);
List<CustomerInformation> getAllCustomer();
CustomerInformation updateCustomer(CustomerInformation customerInformation);
void deleteCustomer(long id);
}
