package com.romitshrivastava.SOLID_Principles.A_Single_Responsibility.Good_Design;

public class Main {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("Keyboard", 2, 750.00);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice); // Print responsibility

        InvoiceRepository repo = new InvoiceRepository();
        repo.save(invoice);     // Save responsibility
    }
}
