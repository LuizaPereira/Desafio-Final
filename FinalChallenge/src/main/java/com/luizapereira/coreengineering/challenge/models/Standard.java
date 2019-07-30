package com.luizapereira.coreengineering.challenge.models;

import com.luizapereira.coreengineering.challenge.persistence.FilesDAO;

import java.util.Comparator;
import java.util.List;

public class Standard {

    private static FilesDAO filesDAO = new FilesDAO();

    private Sale salesRate(SaleType type) {
        List<Sale> saleAux = filesDAO.getSales();
        if(type.equals("+")){
            return saleAux.stream().max(Comparator.comparing(Sale::salePrice)).get();
        } else {
            return saleAux.stream().min(Comparator.comparing(Sale::salePrice)).get();
        }
    }

    public long countPersons() {
        return filesDAO.getPeople().stream().count();
    }

    public long countSalesman() {
        return filesDAO.getSalesmen().stream().count();
    }

    public int biggestSale() {
        return salesRate(SaleType.MaxSale).getId();
    }

    public Salesman WorstSalesmanEver() {
        return filesDAO.getSalesmen().stream().filter(salesman -> salesman.getName().equals(salesRate(SaleType.LowSale).getSalesmanName())).findAny().orElse(null);
    }
}