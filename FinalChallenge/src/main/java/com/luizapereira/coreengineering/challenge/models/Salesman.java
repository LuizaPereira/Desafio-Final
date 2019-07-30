package com.luizapereira.coreengineering.challenge.models;

public class Salesman {

    private String name;
    private String cpf;
    private Double salary;

    public Salesman(String cpf, String name, Double salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return " Name: " + name +
                "\nCPF: " + cpf +
                "\nSalary: '" + salary;
    }
}