package com.romitshrivastava.Design_Patterns.Creational_Pattern.Prototype_Design_Pattern.Deep_Copy;


 interface Prototype {
    Prototype clone();
}

//Concrete Prototype Class (Shallow Copy)

 class Book implements Prototype {
    private int id;
    private String title;
    Author author;

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public Book clone() {
        // Deep copy: clone the Author object too
        Author clonedAuthor = new Author(this.author.toString());
        return new Book(this.id, this.title, clonedAuthor);
    }


    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }

    // Getters and Setters omitted for brevity
}



 class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return name;
    }
}



 class DeepCopy {
    public static void main(String[] args) {
        Author originalAuthor = new Author("J.K. Rowling");
        Book originalBook = new Book(1, "Harry Potter", originalAuthor);

        Book clonedBook = originalBook.clone();

        // Modify clone's author name
        clonedBook.author.setName("George R.R. Martin");

        System.out.println("Original Book: " + originalBook);
        System.out.println("Cloned Book:   " + clonedBook);
    }
}

