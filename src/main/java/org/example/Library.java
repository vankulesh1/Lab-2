package org.example;
import java.util.List;
import java.util.ArrayList;
/*
Library (implements IManageable)
Attributes:
items: List<Item> (to store all items)
patrons: List<Patron> (to store all registered patrons)
Methods:
registerPatron(Patron): Registers a new patron.
lendItem(Patron, Item): Lends an item to a patron.
returnItem(Patron, Item): Returns a borrowed item.
 */
class Library implements IManageable {
    private List<Item> items;
    private List<Patron> patrons;
    public List<Patron> getPatrons() {
        return patrons;
    }
    public Library() {
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }
    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public List<Item> listAvailable() {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : items) {
            if (!item.isBorrowed()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    @Override
    public List<Item> listBorrowed() {
        List<Item> borrowedItems = new ArrayList<>();
        for (Patron patron : patrons) {
            borrowedItems.addAll(patron.getBorrowedItems());
        }
        return borrowedItems;
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (!item.isBorrowed()) {
            item.borrowItem();
            patron.borrow(item);
        } else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Товар вже видано.");
            System.out.println("------------------------------------------------------------");
        }
    }

public void returnItemToLibrary(Patron patron, Item item) {

    if (items.contains(item)) {

        if (patron.hasBorrowedItem(item)) {

            item.returnItem();
            patron.returnItem(item);
            System.out.println("------------------------------------------------------------");
            System.out.println("Предмет з ID " + item.getUniqueID() + " повернено до бібліотеки.");
            System.out.println("------------------------------------------------------------");
        } else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Вказаний читач не отримував цього предмета.");
            System.out.println("------------------------------------------------------------");
        }
    } else {
        System.out.println("------------------------------------------------------------");
        System.out.println("Предмет з ID " + item.getUniqueID() + " не було знайдено в бібліотеці.");
        System.out.println("------------------------------------------------------------");
    }
}

    public void showAvailableItems() {
        System.out.println("Список доступних предметів:");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void showBorrowedItems() {
        System.out.println("Список взятих предметів та їхніх читачів:");
        for (Patron patron : patrons) {
            for (Item borrowedItem : patron.getBorrowedItems()) {
                System.out.println("Читач " + patron.getName() + " взяв " + borrowedItem);
            }
        }
    }
}