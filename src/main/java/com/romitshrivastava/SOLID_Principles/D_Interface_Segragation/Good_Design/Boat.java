package com.romitshrivastava.SOLID_Principles.D_Interface_Segragation.Good_Design;

// Boat class - Implements only Sailable interface
class Boat implements Sailable {
    @Override
    public void sail() {
        System.out.println("Sailing a boat!");
    }
}