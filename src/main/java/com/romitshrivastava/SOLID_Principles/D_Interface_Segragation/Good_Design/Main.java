package com.romitshrivastava.SOLID_Principles.D_Interface_Segragation.Good_Design;

public class Main {
    public static void main(String[] args) {
        Drivable car = new Car();
        car.drive();

        Sailable boat = new Boat();
        boat.sail();
    }
}
