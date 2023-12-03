package org.example;

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




    }
}