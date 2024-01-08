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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class CustomerInformationForm {
    private String title;
    private Map<String, FormField> fields;

    public CustomerInformationForm(String title) {
        this.title = title;
        this.fields = new HashMap<>();
        initializeFields();
    }

    private void initializeFields() {
        addField("name", "Name", "text");
        addField("address", "Home Address", "text");
        addField("phone", "Phone Number", "tel");
        addField("email", "Email", "email");
        addField("stateOfOrigin", "State of Origin", "text");
        addField("dob", "Date of Birth", "date");
    }

    private void addField(String fieldName, String label, String type) {
        FormField field = new FormField(label, type);
        fields.put(fieldName, field);
    }

    public FormField getField(String fieldName) {
        return fields.get(fieldName);
    }

    // expeccted setters and getters !!!!!!!!!!!!!!!!!!!!!!!
}


public class Manu {
    public static void main(String[] args) {
        CustomerInformationForm customerForm = new CustomerInformationForm("Customer Information");

        FormField nameField = customerForm.getField("name");
        System.out.println("Field Label: " + nameField.getLabel());
        System.out.println("Field Type: " + nameField.getType());


    }
}
