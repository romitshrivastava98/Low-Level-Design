package com.romitshrivastava.Design_Patterns.Behavioral_Pattern.Visitor_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

// Visitor interface that defines visit methods for different elements
 interface Visitor {
    void visit(Book book);
    void visit(Magazine magazine);
    void visit(Newspaper newspaper);
}

// ConcreteVisitor that implements the visit methods
 class PrintVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        System.out.println("Printing Book: " + book.getTitle());
    }

    @Override
    public void visit(Magazine magazine) {
        System.out.println("Printing Magazine: " + magazine.getTitle());
    }

    @Override
    public void visit(Newspaper newspaper) {
        System.out.println("Printing Newspaper: " + newspaper.getTitle());
    }
}

 class TaxVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        System.out.println("Tax on Book: " + book.getPrice() * 0.05);
    }

    @Override
    public void visit(Magazine magazine) {
        System.out.println("Tax on Magazine: " + magazine.getPrice() * 0.07);
    }

    @Override
    public void visit(Newspaper newspaper) {
        System.out.println("Tax on Newspaper: " + newspaper.getPrice() * 0.02);
    }
}

// Element interface with accept method to accept visitors
 interface Element {
    void accept(Visitor visitor);
}


// Concrete Element representing a Book
 class Book implements Element {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Element representing a Magazine
 class Magazine implements Element {
    private String title;
    private double price;

    public Magazine(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Element representing a Newspaper
 class Newspaper implements Element {
    private String title;
    private double price;

    public Newspaper(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}




// ObjectStructure that holds a collection of elements
 class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void addElement(Element element) {
        elements.add(element);
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}



// Client to demonstrate how the visitor pattern works
 class VisitorPatternDemo {
    public static void main(String[] args) {
        // Create elements (Book, Magazine, Newspaper)
        Element book = new Book("Design Patterns", 30.0);
        Element magazine = new Magazine("Time", 5.0);
        Element newspaper = new Newspaper("The Daily News", 2.0);

        // Add elements to object structure
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.addElement(book);
        objectStructure.addElement(magazine);
        objectStructure.addElement(newspaper);

        // Create visitors
        Visitor printVisitor = new PrintVisitor();
        Visitor taxVisitor = new TaxVisitor();

        // Perform operations on elements using visitors
        System.out.println("Performing Print Operation:");
        objectStructure.accept(printVisitor);

        System.out.println("\nPerforming Tax Calculation:");
        objectStructure.accept(taxVisitor);
    }
}
