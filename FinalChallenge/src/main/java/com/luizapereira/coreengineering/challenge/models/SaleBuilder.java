package com.luizapereira.coreengineering.challenge.models;

public class SaleBuilder {

    private Sale sale;

    public SaleBuilder() {
        this.sale = new Sale();
    }

    public static SaleBuilder builder() {
        return new SaleBuilder();
    }

    public SaleBuilder addId(int id) {
        this.sale.setId(id);
        return this;
    }

    public SaleBuilder addSalesmanName(String name) {
        this.sale.setSalesmanName(name);
        return this;
    }

    public SaleBuilder addSoldItems(String[] items) {
        SoldItem soldItem = null;
        for (int i = 0; i < items.length; i++) {
            String [] data = items[i].split("-");
            for (int j = 0; j < data.length; j++) {

                soldItem = new SoldItem();
                soldItem.setId(Integer.parseInt(data[0]));
                soldItem.setQuantity(Integer.parseInt(data[1]));
                soldItem.setValue(Double.parseDouble(data[2]));
                this.sale.getSoldItems().add(soldItem);
            }
        }
        return this;
    }

    public Sale getSale() {
        return this.sale;
    }
}