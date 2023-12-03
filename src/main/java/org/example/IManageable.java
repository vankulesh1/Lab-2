package org.example;
import java.util.List;
/*
IManageable (Interface)
Methods:
add(Item): Adds an item.
remove(Item): Removes an item.
listAvailable(): Lists all available items.
listBorrowed(): Lists all borrowed items.
 */
interface IManageable {
    void add(Item item);

    void remove(Item item);

    List<Item> listAvailable();

    List<Item> listBorrowed();
}