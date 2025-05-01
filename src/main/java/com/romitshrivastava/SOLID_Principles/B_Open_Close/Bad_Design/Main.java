package com.romitshrivastava.SOLID_Principles.B_Open_Close.Bad_Design;
 class Main {
    public static void main(String[] args) {
        TaxCalculatorBad taxCalculator = new TaxCalculatorBad();
        double tax = taxCalculator.calculateTax("India", 100000);
        System.out.println("Tax: " + tax);
    }
}