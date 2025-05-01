package com.romitshrivastava.SOLID_Principles.B_Open_Close.Good_Design;

// Concrete Policy for USA
class USATaxPolicy implements TaxPolicy {
    @Override
    public double calculateTax(double income) {
        return income * 0.15;
    }
}