package com.romitshrivastava.Design_Patterns.Structural_Pattern.Bridge_Design_Pattern;


// Step 1: Implementor (MessageSender Interface)
interface MessageSender {
    void sendMessage(String message);
}

// Step 2: Concrete Implementations of MessageSender
class SMS implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class Email implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class WhatsApp implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending WhatsApp Message: " + message);
    }
}

// Step 3: Abstraction (Message class)
abstract class Message {
    protected MessageSender messageSender;  // Bridge to MessageSender

    public Message(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    abstract void send(String content);  // Abstract method
}

// Step 4: Concrete Implementations of Message
class TextMessage extends Message {
    public TextMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    void send(String content) {
        System.out.print("Text Message - ");
        messageSender.sendMessage(content);
    }
}

class EmailMessage extends Message {
    public EmailMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    void send(String content) {
        System.out.print("Email Message - ");
        messageSender.sendMessage(content);
    }
}

// Step 5: Client Code
public class Messenger {
    public static void main(String[] args) {
        Message textMessageSMS = new TextMessage(new SMS());
        textMessageSMS.send("Hello via SMS!");

        Message emailMessageEmail = new EmailMessage(new Email());
        emailMessageEmail.send("Hello via Email!");

        Message textMessageWhatsApp = new TextMessage(new WhatsApp());
        textMessageWhatsApp.send("Hello via WhatsApp!");
    }
}
