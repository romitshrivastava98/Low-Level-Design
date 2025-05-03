package com.romitshrivastava.Design_Patterns.Behavioral_Pattern.Iterator_Design_Pattern;

// Iterator interface that defines methods for traversal
 interface Iterator {
    boolean hasNext(); // Check if there are more elements
    Object next(); // Return the next element
}

// Concrete Iterator that implements the Iterator interface
 class BookIterator implements Iterator {
    private Book[] books;
    private int position = 0;

    public BookIterator(Book[] books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return position < books.length;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return books[position++];
        }
        return null; // or throw exception
    }
}


// Aggregate interface with a method to create an iterator
 interface Aggregate {
    Iterator createIterator(); // Creates an iterator
}

// Concrete collection class that implements the Aggregate interface
 class BookCollection implements Aggregate {
    private Book[] books;
    private int index = 0;

    public BookCollection(int maxSize) {
        books = new Book[maxSize];
    }

    public void addBook(Book book) {
        if (index < books.length) {
            books[index++] = book;
        }
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator(books);
    }
}


// A simple Book class representing the elements in the collection
 class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book [Title: " + title + ", Author: " + author + "]";
    }
}


// Client class demonstrating the use of the Iterator pattern
public class Main {
    public static void main(String[] args) {
        // Create a collection
        BookCollection bookCollection = new BookCollection(3);
        bookCollection.addBook(new Book("1984", "George Orwell"));
        bookCollection.addBook(new Book("Brave New World", "Aldous Huxley"));
        bookCollection.addBook(new Book("Fahrenheit 451", "Ray Bradbury"));

        // Get the iterator for the collection
        Iterator iterator = bookCollection.createIterator();

        // Iterate through the collection
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next(); // Downcast to Book
            System.out.println(book);
        }
    }
}