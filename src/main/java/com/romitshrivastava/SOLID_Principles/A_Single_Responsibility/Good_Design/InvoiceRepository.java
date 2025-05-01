package com.romitshrivastava.SOLID_Principles.A_Single_Responsibility.Good_Design;

class InvoiceRepository {
    public void save(Invoice invoice) {
        // Simulate saving to database
        System.out.println("Saving invoice to database:");
        System.out.println("Item: " + invoice.getItem());
        System.out.println("Quantity: " + invoice.getQuantity());
        System.out.println("Price per item: " + invoice.getPricePerItem());
        System.out.println("Total: " + invoice.calculateTotal());
    }
}