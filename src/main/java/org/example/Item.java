package org.example;
/*
Item (Abstract Class)
Attributes:
title: String
uniqueID: String (unique for each item)
isBorrowed: boolean (default false)
Methods:
Constructors, getters, setters
abstract void borrowItem(): Makes the item as borrowed.
abstract void returnItem(): Marks the item as not borrowed.
 */
public class Item {
    private String title;
    private String uniqueID;
    private boolean isBorrowed;

    public Item(String title, String uniqueID) {
        this.title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowItem() {
        isBorrowed = true;
    }

    public void returnItem() {
        isBorrowed = false;
    }

}