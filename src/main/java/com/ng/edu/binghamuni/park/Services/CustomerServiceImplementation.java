package com.ng.edu.binghamuni.park.Services;

import com.ng.edu.binghamuni.park.Domain.CustomerInformation;
import com.ng.edu.binghamuni.park.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements FormService{
@Autowired
    FormRepository customerRepository;

    @Override
    public CustomerInformation saveCustomer(CustomerInformation customer) {
        return customerRepository.save(customer);
    }

    @Override
    public long getTotalWebAddSourceCount() {
        return customerRepository.countByadSource("Web") *5;
    }

    @Override
    public long getTotalNewspaperSourceCount() {
        return customerRepository.countByadSource("Newspaper") *5;
    }

    @Override
    public long getTotalWordOfMouthSourceCount() {
        return customerRepository.countByadSource("WordOfMouth") *5;
    }

@Override
    public long getTotalCustomers(){
        return customerRepository.findAll().size();
    }
    @Override
    public CustomerInformation getCustomerbyId(long id) {
        Optional<CustomerInformation> customer = customerRepository.findById(id);
        CustomerInformation knownCustomer;
        if(customer.isPresent()){
            knownCustomer = customer.get();
            return knownCustomer;
        }else {
            throw new RuntimeException("Customer not found");
        }
    }

    @Override
    public List<CustomerInformation> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerInformation updateCustomer(CustomerInformation customerInformation) {
        Optional<CustomerInformation> customerInformation1 = customerRepository.findById(customerInformation.getId());
        CustomerInformation customer = new CustomerInformation();
        if(customerInformation1.isPresent()){
            customer.setName(customer.getName());
            customer.setAddress(customer.getAddress());
            customer.setEmail(customer.getEmail());
            customer.setPhone(customer.getPhone());
            customer.setId(customer.getId());
        }
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    public String calculateHighestAdSource() {
        // Implement your logic to calculate the highest advertisement source
        // For simplicity, let's assume you have a method in your repository to get the highest ad source
        long webAd = customerRepository.countByadSource("Web");
        long wordOfMouthAd = customerRepository.countByadSource("WordOfMouth");
        long newspaperAd = customerRepository.countByadSource("Newspaper");

        if (webAd > wordOfMouthAd && webAd > newspaperAd) {
            return "Web";
        } else if (wordOfMouthAd > webAd && wordOfMouthAd > newspaperAd) {
            return "Word Of Mouth";
        } else if (newspaperAd > webAd && newspaperAd > wordOfMouthAd) {
            return "Newspaper";
        } else {
            // Handle the case where there's a tie or all counts are zero
            return "No highest ad source found";
        }
    }

    public double calculateHighestAdPercentage() {
        // Implement your logic to calculate the highest advertisement percentage
        // For simplicity, let's assume you have a method in your repository to get the total number of customers
        long totalCustomers = customerRepository.countByadSource("Web");
        int totalAds = customerRepository.findAll().size();; // Implement this method in your repository

        if (totalCustomers > 0) {
            return ((double) totalAds / totalCustomers) * 100;
        } else {
            return 0.0; // Avoid division by zero
        }
    }
}
