package com.romitshrivastava.SOLID_Principles.D_Interface_Segragation.Bad_Design;

// Car class - Doesn't need to implement sail method
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car!");
    }

    @Override
    public void sail() {
        // A car cannot sail, so it might throw an exception
        throw new UnsupportedOperationException("A car cannot sail!");
    }
}