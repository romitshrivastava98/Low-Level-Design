package com.romitshrivastava.SOLID_Principles.C_Liskov_Substitution.Bad_Design;

// Subclass Square
class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }
}