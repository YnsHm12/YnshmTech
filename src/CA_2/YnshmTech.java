/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CA_2;
import java.util.Scanner;
/**
 *
 * @author Marwan
 */
public class YnshmTech {

    /**
     * @param args the command line arguments
     */
     enum MenuOption {
        SORT, SEARCH, ADD_RECORDS, GENERATE_RANDOM, EXIT
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); // Scanner for input
        boolean running = true; // Loop control
        TechCompanyService service = new TechCompanyService(); // Logic handler

        while (running) {
            System.out.println("\n=== YnshmTech Employee Management ===");
            for (int i = 0; i < MenuOption.values().length; i++) {
                System.out.println((i + 1) + ". " + MenuOption.values()[i].toString().replace("_", " "));
            }
            System.out.print("Select option (1-" + MenuOption.values().length + "): ");
            if (sc.hasNextInt()) {
                int option = sc.nextInt();
                sc.nextLine(); // Clear newline

                if (option >= 1 && option <= MenuOption.values().length) {
                    switch (MenuOption.values()[option - 1]) {
                        case SORT:
                            service.handleSort();
                            break;
                        case SEARCH:
                            service.handleSearch(sc);
                            break;
                        case ADD_RECORDS:
                            service.handleAdd(sc);
                            break;
                        case GENERATE_RANDOM:
                            service.generateRandomEmployees(10);
                            break;
                        case EXIT:
                            running = false;
                            break;
                    }
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and " + MenuOption.values().length);
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear invalid input
            }
        }

        sc.close();
    }

    
}
