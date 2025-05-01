package com.romitshrivastava.SOLID_Principles.E_Dependency_Inversion.Good_Design;

public class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailSender();
        OrderService orderWithEmail = new OrderService(emailNotifier);
        orderWithEmail.placeOrder();

        Notifier smsNotifier = new SMSSender();
        OrderService orderWithSMS = new OrderService(smsNotifier);
        orderWithSMS.placeOrder();
    }
}
