package com.ng.edu.binghamuni.park.Services;

import com.ng.edu.binghamuni.park.Domain.CustomerInformation;
import com.ng.edu.binghamuni.park.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

 public String calculateHighestAdSources() {
    
    long webAd = customerRepository.countByadSource("Web");
    long wordOfMouthAd = customerRepository.countByadSource("WordOfMouth");
    long newspaperAd = customerRepository.countByadSource("Newspaper");

    List<String> highestAdSources = new ArrayList<>();

    long maxCount = Math.max(Math.max(webAd, wordOfMouthAd), newspaperAd);

    if (webAd == maxCount) {
        highestAdSources.add("Web");
    }
    if (wordOfMouthAd == maxCount) {
        highestAdSources.add("Word Of Mouth");
    }
    if (newspaperAd == maxCount) {
        highestAdSources.add("Newspaper");
    }

    if (!highestAdSources.isEmpty()) {
        if (highestAdSources.size() == 1) {
            return highestAdSources.get(0);
        } else if (highestAdSources.size() == 2) {
            return highestAdSources.get(0) + " & " + highestAdSources.get(1); // Return two sources separated by "&"
        } else {
            return highestAdSources.get(0) + " & " + highestAdSources.get(1); // Return the first two sources
        }
    } else {
        return "No highest ad source found";
    }
}


   public double calculateHighestAdPercentage(String source) {
    // Implement your logic to calculate the highest advertisement percentage
    // For simplicity, let's assume you have a method in your repository to get the total number of customers
    long webAd = customerRepository.countByadSource("Web");
    long newspaperAd = customerRepository.countByadSource("Newspaper");
    long wordOfMouthAd = customerRepository.countByadSource("WordOfMouth");
    long totalCustomers = customerRepository.count(); // Use count method directly
    
    if (totalCustomers > 0) {
        if ("Web".equals(source)) {
            return ((double) webAd / totalCustomers) * 100;
        } else if ("Newspaper".equals(source)) {
            return ((double) newspaperAd / totalCustomers) * 100;
        } else if ("WordOfMouth".equals(source)) {
            return ((double) wordOfMouthAd / totalCustomers) * 100;
        } else {
            // Handle the case where the source is not recognized
            return 0.0;
        }
    } else {
        return 0.0; // Avoid division by zero
    }
}

public FormRepository getCustomerRepository() {
    return customerRepository;
}

public void setCustomerRepository(FormRepository customerRepository) {
    this.customerRepository = customerRepository;
}

@Override
public String calculateHighestAdSource() {
    
    throw new UnsupportedOperationException("Unimplemented method 'calculateHighestAdSource'");
}

@Override
public double calculateHighestAdPercentage() {
    
    throw new UnsupportedOperationException("Unimplemented method 'calculateHighestAdPercentage'");
}

}
