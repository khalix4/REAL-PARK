package com.ng.edu.binghamuni.park.Services;

import com.ng.edu.binghamuni.park.Domain.customerInformationForm;
import com.ng.edu.binghamuni.park.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImplementation implements FormService{
    @Autowired
    FormRepository formRepository;

    public customerInformationForm submit(customerInformationForm customerInfo){ return (customerInformationForm) formRepository.save(customerInfo);

    }
    public List<customerInformationForm> dropDown(){

        return formRepository.findAll();

    }
}
