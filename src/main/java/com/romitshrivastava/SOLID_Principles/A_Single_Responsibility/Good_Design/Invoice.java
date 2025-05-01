package com.romitshrivastava.SOLID_Principles.A_Single_Responsibility.Good_Design;

// Business logic class: only calculates total
class Invoice {
    private String item;
    private int quantity;
    private double pricePerItem;

    public Invoice(String item, int quantity, double pricePerItem) {
        this.item = item;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public double calculateTotal() {
        return quantity * pricePerItem;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }
}


