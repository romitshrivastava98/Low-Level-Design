package com.romitshrivastava.SOLID_Principles.B_Open_Close.Good_Design;

// You can add new country policy without modifying existing code
class JapanTaxPolicy implements TaxPolicy {
    @Override
    public double calculateTax(double income) {
        return income * 0.18;
    }
}