package com.romitshrivastava.SOLID_Principles.B_Open_Close.Bad_Design;

class TaxCalculatorBad {
    public double calculateTax(String country, double income) {
        if (country.equalsIgnoreCase("India")) {
            return income * 0.10;
        } else if (country.equalsIgnoreCase("USA")) {
            return income * 0.15;
        } else if (country.equalsIgnoreCase("Germany")) {
            return income * 0.20;
        }
        // What if we need to add Japan? Modify this method again!
        return 0;
    }
}