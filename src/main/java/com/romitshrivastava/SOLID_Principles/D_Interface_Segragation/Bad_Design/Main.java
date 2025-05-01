package com.romitshrivastava.SOLID_Principles.D_Interface_Segragation.Bad_Design;

// Main class to test the bad design
public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.drive();
        // This would throw an exception, which is not ideal
        // car.sail();

        Vehicle boat = new Boat();
        // This would throw an exception, which is not ideal
        // boat.drive();
        boat.sail();
    }
}
