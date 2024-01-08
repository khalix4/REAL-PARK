package com.ng.edu.binghamuni.park.Domain;

public class customerInformationForm {

    // Constructors
    public customerInformationForm(String title) {
    }

    public static void main(String[] args) {
        customerInformationForm customerForm = new customerInformationForm("Customer Information");

        customerInformation customerInfo = customerInformation.getCustomerInformationFromUser();

        displayCustomerInformation(customerInfo);
    }

    private static void displayCustomerInformation(customerInformation customerInfo) {
        System.out.println("\nCustomer Information:");
        System.out.println("Name: " + customerInfo.getName());
        System.out.println("Address: " + customerInfo.getAddress());
        System.out.println("Phone Number: " + customerInfo.getPhone());
        System.out.println("Email: " + customerInfo.getEmail());
        System.out.println("State of Origin: " + customerInfo.getStateOfOrigin());
        System.out.println("Date of Birth: " + customerInfo.getDob());
    }
}
