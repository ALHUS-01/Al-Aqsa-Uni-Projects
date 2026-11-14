// Husam Akram Hamad Braika - 1320237093
package husamakrambraika_1320237093;

import java.util.Scanner;

public class Library {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Process manager = new Process();
        boolean exit = false;

        while (!exit) {
            System.out.println(Process.CYAN + "=======================================================");
            System.out.println(Process.CYAN + "         === Library Management System ===");
            System.out.println(Process.CYAN + "=======================================================");
            
            // --- Book Operations ---
            System.out.println(Process.GREEN + "1. Show Books");
            System.out.println(Process.GREEN + "2. Add a Book");
            System.out.println(Process.GREEN + "3. Delete a Book");
            System.out.println(Process.GREEN + "4. Edit Book Quantity");
            System.out.println(Process.GREEN + "5. Search for a Book");
            
            // --- Student Operations ---
            System.out.println(Process.GREEN + "6. Show Students");
            System.out.println(Process.GREEN + "7. Add a Student");
            System.out.println(Process.GREEN + "8. Delete a Student");
            System.out.println(Process.GREEN + "9. Deposit Money to Student Budget");
            System.out.println(Process.GREEN + "10. Buy a Book");
            
            // --- General Operations ---
            System.out.println(Process.GREEN + "11. Full Report / Statistics");
            System.out.println(Process.GREEN + "12. Exit");
            System.out.print(Process.CYAN + "Choose an option: " + Process.RESET);

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    manager.showBooks();
                    break;
                case "2":
                    manager.addBook();
                    break;
                case "3":
                    manager.deleteBook();
                    break;
                case "4":
                    manager.editBookQuantity();
                    break;
                case "5":
                    manager.searchBook();
                    break;
                case "6":
                    manager.showStudents();
                    break;
                case "7":
                    manager.addStudent();
                    break;
                case "8":
                    manager.deleteStudent();
                    break;
                case "9":
                    manager.depositMoney();
                    break;
                case "10":
                    manager.buyBookMenu();
                    break;
                case "11":
                    manager.printStatistics();
                    break;
                case "12":
                    manager.saveData();
                    exit = true;
                    break;
                default:
                    System.out.println(Process.RED + "Invalid choice. Try again." + Process.RESET);
            }
        }
        input.close();
    }
}
// Husam Akram Hamad Braika - 1320237093