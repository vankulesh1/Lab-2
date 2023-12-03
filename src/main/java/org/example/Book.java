package org.example;
/*
Book (implements Item)
Attributes:
author: String
Methods:
borrowItem(): Implements the abstract method from Item.
returnItem(): Implements the abstract method from Item.
*/

class Book extends Item {
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

        public String getAuthor() {
        return author;
    }
}