package com.romitshrivastava.SOLID_Principles.D_Interface_Segragation.Bad_Design;

// Bad Design: One interface for all vehicle types
interface Vehicle {
    void drive();
    void sail();
}
