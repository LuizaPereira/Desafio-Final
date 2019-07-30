package com.luizapereira.coreengineering.challenge.persistence;

import com.luizapereira.coreengineering.challenge.exceptions.InvalidIdentifierException;
import com.luizapereira.coreengineering.challenge.models.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilesDAO {

    private static final String INPUT_PATH = System.getProperty("user.home") + "/data/in/";
    private static final String OUTPUT_PATH = System.getProperty("user.home") + "/data/out/ReportOutput.done.dat";
    private static Standard standard = new Standard();
    private static List<Person> people = new ArrayList<>();
    private static List<Sale> sales = new ArrayList<>();
    private static List<Salesman> salesmen = new ArrayList<>();

    public void readFile(String fileName) throws IOException {
        try(FileReader fileReader = new FileReader(INPUT_PATH + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                treatData(line);
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void writeFile() throws IOException {
        try(FileWriter fileWriter = new FileWriter(OUTPUT_PATH)) {
            fileWriter.write("Quantity of customers: " + standard.countPersons() + "\n"
                    + "Quantity of Salesmen: " + standard.countSalesman() + "\n"
                    + "Biggest sale id: " + standard.biggestSale() + "\n"
                    + "Worst Salesman Ever: " + standard.WorstSalesmanEver());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    private void treatData(String line) {
        if (line != "") {
            String delimiter = line.substring(3,4);
            String[] data = line.split(delimiter);

            switch (data[0]) {
                case "001":
                    populateSalesmen(data[1], data[2], Double.parseDouble(data[3]));
                    break;
                case "002":
                    populatePeople(data[1], data[2], data[3]);
                    break;
                case "003":
                    populateSales(Integer.parseInt(data[1]), data[2].replace("[", "").replace("]", "").split(","), data[3]);
                    break;
                default:
                    throw new InvalidIdentifierException("Invalid identifier!");
            }
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public List<Salesman> getSalesmen() {
        return salesmen;
    }

    private void populatePeople(String cnpj, String name, String businessArea) {
        this.people.add(new Person(cnpj, name, businessArea));
    }

    private void populateSales(int id, String[] items, String salesmanName) {
        this.sales.add(SaleBuilder.builder().addId(id).addSoldItems(items).addSalesmanName(salesmanName).getSale());
    }

    private void populateSalesmen(String cpf, String name, Double salary) {
        this.salesmen.add(new Salesman(cpf, name, salary));
    }
}