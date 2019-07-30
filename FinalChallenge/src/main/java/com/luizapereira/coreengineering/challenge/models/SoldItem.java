package com.luizapereira.coreengineering.challenge.models;

public class SoldItem {

    private int id;
    private Double value;
    private int quantity;

    public void setId(int id) { this.id = id; }

    public Double getValue() { return this.value; }

    public void setValue(Double value) { this.value = value; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return " Id: " + id +
                "\nValue: " + value +
                "\nQuantity: '" + quantity;
    }
}
