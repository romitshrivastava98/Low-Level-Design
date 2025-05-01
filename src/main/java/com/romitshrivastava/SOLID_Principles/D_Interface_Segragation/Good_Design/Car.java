package com.romitshrivastava.SOLID_Principles.D_Interface_Segragation.Good_Design;

// Car class - Implements only Drivable interface
class Car implements Drivable {
    @Override
    public void drive() {
        System.out.println("Driving a car!");
    }
}
