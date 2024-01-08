package com.ng.edu.binghamuni.park.Services;

import com.ng.edu.binghamuni.park.Domain.customerInformationForm;

import java.util.List;

public interface FormService {
    customerInformationForm submit(customerInformationForm customerInfo);
    List<customerInformationForm> dropDown();
}
