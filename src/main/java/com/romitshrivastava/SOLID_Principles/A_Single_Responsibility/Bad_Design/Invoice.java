package com.romitshrivastava.SOLID_Principles.A_Single_Responsibility.Bad_Design;

class Invoice {
    String item;
    int quantity;
    double pricePerItem;

    public Invoice(String item, int quantity, double pricePerItem) {
        this.item = item;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public double calculateTotal() {
        return quantity * pricePerItem;
    }

    public void printInvoice() {
        System.out.println("Invoice:");
        System.out.println("Item: " + item);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per Item: " + pricePerItem);
        System.out.println("Total: " + calculateTotal());
    }

    public void saveToFile() {
        System.out.println("Saving invoice to database or file...");
    }
}
