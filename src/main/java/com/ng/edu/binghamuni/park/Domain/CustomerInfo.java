package com.ng.edu.binghamuni.park.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Represents customer information
class customerInformation {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String stateOfOrigin;
    private Date dob;

    // Constructors
    public customerInformation() {
        // Default constructor
    }

    public customerInformation(String name, String address, String phone, String email, String stateOfOrigin, Date dob) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.stateOfOrigin = stateOfOrigin;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public static customerInformation getCustomerInformationFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Customer Information:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("State of Origin: ");
        String stateOfOrigin = scanner.nextLine();

        Date dob = getDOBFromUser();

        return new customerInformation(name, address, phone, email, stateOfOrigin, dob);
    }

    private static Date getDOBFromUser() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Date of Birth (yyyy-MM-dd): ");
        String dobString = scanner.nextLine();

        try {
            return dateFormat.parse(dobString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return getDOBFromUser(); // Retry if the input is invalid
        }
    }
}

class customerInformationForm {
    private String title;

    // Constructors
    public customerInformationForm(String title) {
        this.title = title;
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
