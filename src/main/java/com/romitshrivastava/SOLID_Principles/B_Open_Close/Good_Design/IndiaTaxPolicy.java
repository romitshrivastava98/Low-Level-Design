package com.romitshrivastava.SOLID_Principles.B_Open_Close.Good_Design;

// Concrete Policy for India
class IndiaTaxPolicy implements TaxPolicy {
    @Override
    public double calculateTax(double income) {
        return income * 0.10;
    }
}