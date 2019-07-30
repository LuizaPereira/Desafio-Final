package com.luizapereira.coreengineering.challenge.models;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private int id;
    private static List<SoldItem> soldItems = new ArrayList<>();
    private String salesmanName;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<SoldItem> getSoldItems() { return soldItems; }

    public String getSalesmanName() { return salesmanName; }

    public void setSalesmanName(String salesmanName) { this.salesmanName = salesmanName; }

    public Double salePrice() { return getSoldItems().stream().map(SoldItem::getValue).reduce((a, b) -> a * b).get(); }
}

