package com.romitshrivastava.SOLID_Principles.D_Interface_Segragation.Bad_Design;

// Boat class - Doesn't need to implement drive method
class Boat implements Vehicle {
    @Override
    public void drive() {
        // A boat cannot drive, so it might throw an exception
        throw new UnsupportedOperationException("A boat cannot drive!");
    }

    @Override
    public void sail() {
        System.out.println("Sailing a boat!");
    }
}