package com.romitshrivastava.SOLID_Principles.B_Open_Close.Good_Design;

// Tax Calculator uses abstraction
class TaxCalculator {
    private TaxPolicy taxPolicy;

    public TaxCalculator(TaxPolicy taxPolicy) {
        this.taxPolicy = taxPolicy;
    }

    public double calculate(double income) {
        return taxPolicy.calculateTax(income);
    }
}