package org.example;
import java.util.List;
import java.util.ArrayList;
/*
Patron
Attributes:
name: String
ID: String (unique for each patron)
borrowedItems: List<Item>
Methods:
Constructors, getters, setters
borrow(Item): Adds an item to the patron's borrowed list.
return(Item): Removes an item from the patron's borrowed list.
 */
public class Patron {

    private String name;
    private String ID;
    private List<Item> borrowedItems;
    public Patron(String name, String ID){
        this.name = name;
        this.ID = ID;
        this.borrowedItems = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public boolean hasBorrowedItem(Item item) {
        return borrowedItems.contains(item);
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrow(Item item) {
        borrowedItems.add(item);
    }

    public void returnItem(Item item) {
        borrowedItems.remove(item);
    }

}
