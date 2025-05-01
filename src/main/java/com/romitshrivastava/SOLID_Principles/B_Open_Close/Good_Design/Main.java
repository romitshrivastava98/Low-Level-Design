package com.romitshrivastava.SOLID_Principles.B_Open_Close.Good_Design;

class Main {
    public static void main(String[] args) {
        double income = 100000;

        TaxCalculator indiaTax = new TaxCalculator(new IndiaTaxPolicy());
        TaxCalculator usaTax = new TaxCalculator(new USATaxPolicy());
        TaxCalculator germanyTax = new TaxCalculator(new GermanyTaxPolicy());
        TaxCalculator japanTax = new TaxCalculator(new JapanTaxPolicy());

        System.out.println("India Tax: ₹" + indiaTax.calculate(income));
        System.out.println("USA Tax: $" + usaTax.calculate(income));
        System.out.println("Germany Tax: €" + germanyTax.calculate(income));
        System.out.println("Japan Tax: ¥" + japanTax.calculate(income));
    }
}
