package org.example;
/*
DVD (implements Item)
Attributes:
duration: int (minutes)
Methods:
borrowItem(): Implements the abstract method from Item.
returnItem(): Implements the abstract method from Item.
 */
class DVD extends Item {
    private int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}