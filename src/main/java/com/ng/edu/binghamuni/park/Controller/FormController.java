package com.ng.edu.binghamuni.park.Controller;

import com.ng.edu.binghamuni.park.Domain.CustomerInformation;
import com.ng.edu.binghamuni.park.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/customer")
    public ResponseEntity<List<CustomerInformation>> getAllCustomers() {
        return  ResponseEntity.ok().body(customerService.getAllCustomer());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerInformation> getCustomerById(@PathVariable Long id) {
        return  ResponseEntity.ok().body(customerService.getCustomerbyId(id));
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerInformation> saveCustomer(@RequestBody CustomerInformation customer) {
        return  ResponseEntity.ok().body(customerService.saveCustomer(customer));
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerInformation> updateCustomer(@PathVariable Long id, @RequestBody CustomerInformation customer) {
        customer.setId(id);
        return  ResponseEntity.ok().body(customerService.updateCustomer(customer));
    }

    @DeleteMapping("/customer/{id}")
    public HttpStatus deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return HttpStatus.OK;
    }
    @GetMapping("/total-web-source")
    public long getTotalWebAddSourceCount() {
        return customerService.getTotalWebAddSourceCount();
    }

    @GetMapping("/total-newspaper-source")
    public long getTotalNewspaperSourceCount() {
        return customerService.getTotalNewspaperSourceCount();
    }

    @GetMapping("/total-word-of-mouth-source")
    public long getTotalWordOfMouthSourceCount() {
        return customerService.getTotalWordOfMouthSourceCount();
    }
}
