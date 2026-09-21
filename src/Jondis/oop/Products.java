package jondis.oop;


import fileworks.DataImport;

import java.util.ArrayList;

class Product{
    private String name;
    private String category;
    private int amount;
    private int pricePerPiece;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            this.amount = 0;
        }
    }

    public int getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(int pricePerPiece) {
        if (pricePerPiece >= 0) {
            this.pricePerPiece = pricePerPiece;
        } else {
            this.pricePerPiece = 0;
        }
    }

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Product(String name, String category, int amount) {
        this(name, category);
        this.amount = amount;
    }

    public Product(String name, String category, int amount, int pricePerPiece) {
        this(name, category, amount);
        this.pricePerPiece = pricePerPiece;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", pricePerPiece=" + pricePerPiece +
                '}';
    }
}

public class Products {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/products.txt");
        // načíst celý soubor a vypsat počet kusů na skladu


        ArrayList<Product> products = new ArrayList<>();
        while (di.hasNext()) {
            String line = di.readLine();
            String[] data = line.split(";");

            Product product = new Product(
                    data[0],
                    data[1],
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]));
        }


        di.finishImport();
    }
}
