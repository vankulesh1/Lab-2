package org.example;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Вітаємо в нашій бібліотеці. Оберіть потрібний пункт");
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Додати предмет (книги, DVD) до бібліотеки");
            System.out.println("2. Видалити предмет");
            System.out.println("3. Реєстрація читача");
            System.out.println("4. Видати предмет читачеві");
            System.out.println("5. Повернути предмет у бібліотеку");
            System.out.println("6. Показати список доступних предметів");
            System.out.println("7. Показати список взятих предметів та їхніх читачів");
            System.out.println("8. Вийти");
            System.out.println("------------------------------------------------------------");

            int number = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
            switch (number) {
                case 1:
                    addItemToLibrary(library, scanner);
                    break;
                case 2:
                    removeItemFromLibrary(library, scanner);
                    break;
                case 3:
                    registerPatron(library, scanner);
                    break;
                case 4:
                    lendItemToPatron(library, scanner);
                    break;
                case 5:
                    returnItemToLibrary(library, scanner);
                    break;
                case 6:
                    showAvailableItems(library);
                    break;
                case 7:
                    showBorrowedItems(library);
                    break;
                case 8:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Дякуємо за використання нашої біблотеки!");
                    System.out.println("------------------------------------------------------------");
                    System.exit(0);
                default:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Немає такого пункту. Оберіть ще раз.");
                    System.out.println("------------------------------------------------------------");
            }
        }
    }

    private static void addItemToLibrary(Library library, Scanner scanner) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Оберіть предмет, з яким потрібно працювати (додати, чи видати):");
        System.out.println("1. Книга");
        System.out.println("2. DVD");
        System.out.println("------------------------------------------------------------");

        int numberType = scanner.nextInt();
        scanner.nextLine();
        System.out.println("------------------------------------------------------------");
        System.out.println("Введіть назву предмета, який ви обрали:");
        System.out.println("------------------------------------------------------------");
        String title = scanner.nextLine();
        System.out.println("------------------------------------------------------------");
        System.out.println("Введіть унікальний номер ID предмета, який ви обрали:");
        System.out.println("------------------------------------------------------------");
        String uniqueID = scanner.nextLine();

        switch (numberType) {
            case 1:
                System.out.println("------------------------------------------------------------");
                System.out.println("Введіть ім'я автора книги, яку потрібно додати:");
                System.out.println("------------------------------------------------------------");
                String author = scanner.nextLine();
                Book book = new Book(title, uniqueID, author);
                library.add(book);
                System.out.println("------------------------------------------------------------");
                System.out.println("Книга додана до вашої бібліотеки.");
                System.out.println("------------------------------------------------------------");
                break;
            case 2:
                System.out.println("------------------------------------------------------------");
                System.out.println("Введіть тривалість DVD (хвилини):");
                System.out.println("------------------------------------------------------------");
                int duration = scanner.nextInt();
                DVD dvd = new DVD(title, uniqueID, duration);
                library.add(dvd);
                System.out.println("------------------------------------------------------------");
                System.out.println("DVD додано до вашої бібліотеки.");
                System.out.println("------------------------------------------------------------");
                break;
            default:
                System.out.println("------------------------------------------------------------");
                System.out.println("Ви обрали неправильний предмет.");
                System.out.println("------------------------------------------------------------");
                break;
        }
    }

    private static void removeItemFromLibrary(Library library, Scanner scanner) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Введіть унікальний ID предмета, який ви хочете видалити:");
        System.out.println("------------------------------------------------------------");
        String uniqueID = scanner.nextLine();

        Item itemToRemove = findItemByID(library, uniqueID);

        if (itemToRemove != null) {
            library.remove(itemToRemove);
            System.out.println("------------------------------------------------------------");
            System.out.println("Предмет?який ви обрали видалено з бібліотеки.");
            System.out.println("------------------------------------------------------------");
        } else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Предмет з унікальним ID " + uniqueID + " не знайдено в бібліотеці.");
            System.out.println("------------------------------------------------------------");
        }
    }

    private static Item findItemByID(Library library, String uniqueID) {
        for (Item item : library.listAvailable()) {
            if (item.getUniqueID().equals(uniqueID)) {
                return item;
            }
        }
        return null;
    }

    private static void registerPatron(Library library, Scanner scanner) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Введіть ім'я читача:");
        System.out.println("------------------------------------------------------------");
        String name = scanner.nextLine();
        System.out.println("------------------------------------------------------------");
        System.out.println("Введіть унікальний ID читача:");
        System.out.println("------------------------------------------------------------");
        String ID = scanner.nextLine();

        Patron patron = new Patron(name, ID);
        library.registerPatron(patron);
        System.out.println("------------------------------------------------------------");
        System.out.println("Читача " + name + " з таким ID " + ID + " зареєстровано.");
        System.out.println("------------------------------------------------------------");
    }


    private static void lendItemToPatron(Library library, Scanner scanner) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Введіть унікальний ID читача, якому ви хочете видати предмет:");
        System.out.println("------------------------------------------------------------");
        String patronID = scanner.nextLine();

        Patron patron = findPatronByID(library, patronID);

        if (patron != null) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Введіть унікальний ID предмета, який ви хочете видати:");
            System.out.println("------------------------------------------------------------");
            String itemID = scanner.nextLine();

            Item itemToLend = findItemByID(library, itemID);

            if (itemToLend != null && !itemToLend.isBorrowed()) {
                library.lendItem(patron, itemToLend);
                System.out.println("------------------------------------------------------------");
                System.out.println("Цей Предмет видано читачеві " + patron.getName() + ".");
                System.out.println("------------------------------------------------------------");
            } else if (itemToLend == null) {
                System.out.println("------------------------------------------------------------");
                System.out.println("Предмет з унікальним ID " + itemID + " не знайдено в бібліотеці.");
                System.out.println("------------------------------------------------------------");
            } else {
                System.out.println("------------------------------------------------------------");
                System.out.println("Предмет з унікальним ID " + itemID + " вже взятий читачем або недоступний.");
                System.out.println("------------------------------------------------------------");
            }
        } else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Читача з унікальним ID " + patronID + " не знайдено в бібліотеці.");
            System.out.println("------------------------------------------------------------");
        }
    }

    private static Patron findPatronByID(Library library, String patronID) {
        for (Patron patron : library.getPatrons()) {
            if (patron.getID().equals(patronID)) {
                return patron;
            }
        }
        return null;
    }


    private static void returnItemToLibrary(Library library, Scanner scanner) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Введіть унікальний ID читача, який повертає предмет:");
        System.out.println("------------------------------------------------------------");
        String patronID = scanner.nextLine();

        Patron patron = findPatronByID(library, patronID);

        if (patron != null) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Введіть унікальний ID предмета, який повертається у бібліотеку:");
            System.out.println("------------------------------------------------------------");
            String itemID = scanner.nextLine();

            Item itemToReturn = findItemByID(library, itemID);

            if (itemToReturn != null && patron.hasBorrowedItem(itemToReturn)) {
                library.returnItem(patron, itemToReturn);
                System.out.println("------------------------------------------------------------");
                System.out.println("Предмет повернено у бібліотеку.");
                System.out.println("------------------------------------------------------------");
            } else if (itemToReturn == null) {
                System.out.println("------------------------------------------------------------");
                System.out.println("Предмет з унікальним ID " + itemID + " не знайдено в бібліотеці.");
                System.out.println("------------------------------------------------------------");
            } else {
                System.out.println("------------------------------------------------------------");
                System.out.println("Читач " + patron.getName() + " не брав цей предмет з бібліотеки.");
                System.out.println("------------------------------------------------------------");
            }
        } else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Читача з унікальним ID " + patronID + " не знайдено в бібліотеці.");
            System.out.println("------------------------------------------------------------");
        }
    }


    private static void showAvailableItems(Library library) {
        List<Item> availableItems = library.listAvailable();

        if (availableItems.isEmpty()) {
            System.out.println("------------------------------------------------------------");
            System.out.println("У бібліотеці немає доступних предметів.");
            System.out.println("------------------------------------------------------------");
        } else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Весь перелік доступних предметів:");
            System.out.println("------------------------------------------------------------");

            for (Item item : availableItems) {
                System.out.println(item.toString());
            }
        }
    }


    private static void showBorrowedItems(Library library) {
        List<Patron> patrons = library.getPatrons();

        if (patrons.isEmpty()) {
            System.out.println("------------------------------------------------------------");
            System.out.println("У бібліотеці ще немає читачів.");
            System.out.println("------------------------------------------------------------");
        } else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Список взятих предметів та читачів:");
            System.out.println("------------------------------------------------------------");

            for (Patron patron : patrons) {
                List<Item> borrowedItems = patron.getBorrowedItems();

                if (!borrowedItems.isEmpty()) {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Читач " + patron.getName() + " (ID: " + patron.getID() + ") має на руках:");
                    System.out.println("------------------------------------------------------------");
                    for (Item item : borrowedItems) {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("  - " + item.getTitle() + " (ID: " + item.getUniqueID() + ")");
                        System.out.println("------------------------------------------------------------");
                    }
                }
            }
        }
    }

}