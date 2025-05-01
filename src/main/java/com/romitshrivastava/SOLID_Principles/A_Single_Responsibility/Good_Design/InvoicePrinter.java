package com.romitshrivastava.SOLID_Principles.A_Single_Responsibility.Good_Design;

class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("------ Invoice ------");
        System.out.println("Item: " + invoice.getItem());
        System.out.println("Quantity: " + invoice.getQuantity());
        System.out.println("Price per Item: " + invoice.getPricePerItem());
        System.out.println("Total: " + invoice.calculateTotal());
        System.out.println("---------------------");
    }
}