package com.ng.edu.binghamuni.park.Domain;

import java.util.HashMap;
import java.util.Map;


class FormField {
    private String label;
    private String type;

    public FormField(String label, String type) {
        this.label = label;
        this.type = type;
    }

}


class Form {
    private String title;
    private Map<String, FormField> fields;

    public Form(String title) {
        this.title = title;
        this.fields = new HashMap<>();
    }

    public void addField(String fieldName, String label, String type) {
        FormField field = new FormField(label, type);
        fields.put(fieldName, field);
    }

    public FormField getField(String fieldName) {
        return fields.get(fieldName);
    }

}

class CustomerInformation {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String stateOfOrigin;
    private String dateOfBirth;

    public CustomerInformation() {

    }

    public CustomerInformation(String name, String address, String phone, String email, String stateOfOrigin, String dateOfBirth) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.stateOfOrigin = stateOfOrigin;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and setters
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

class VehicleInformation {
    private String brand;
    private String model;
    private String color;
    private String plateNumber;
    private String engineType;

    public VehicleInformation() {

    }

    public VehicleInformation(String brand, String model, String color, String plateNumber, String engineType) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.plateNumber = plateNumber;
        this.engineType = engineType;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}

 public class FormExample {
    public static void main(String[] args) {
        Form customerForm = new Form("Customer Information Form");
        customerForm.addField("name", "Name", "text");
        customerForm.addField("address", "Home Address", "text");
        customerForm.addField("phone", "Phone Number", "tel");
        customerForm.addField("email", "Email", "email");
        customerForm.addField("stateOfOrigin", "State of Origin", "text");
        customerForm.addField("dateOfBirth", "Date of Birth", "date");

        Form vehicleForm = new Form("Vehicle Information Form");
        vehicleForm.addField("brand", "Car Brand", "text");
        vehicleForm.addField("model", "Car Model", "text");
        vehicleForm.addField("color", "Car Color", "text");
        vehicleForm.addField("plateNumber", "Plate Number", "text");
        vehicleForm.addField("engineType", "Engine Type", "text");

    }
}
