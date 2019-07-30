package com.luizapereira.coreengineering.challenge.models;

public class Person {

    private String name;
    private String cnpj;
    private String businessArea;

    public Person(String name, String cnpj, String businessArea) {
        this.name = name;
        this.cnpj = cnpj;
        this.businessArea = businessArea;
    }

    @Override
    public String toString() {
        return " Name: " + name +
                "\nCNPJ: " + cnpj +
                "\nBusiness Area: '" + businessArea;
    }
}