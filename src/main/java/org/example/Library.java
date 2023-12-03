package org.example;
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

    public void returnItem(Patron patron, Item item) {
        if (patron.getBorrowedItems().contains(item)) {
            item.returnItem();
            patron.returnItem(item);
        } else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Бібліотекар не видавав цей предмет");
            System.out.println("------------------------------------------------------------");
        }
    }
}