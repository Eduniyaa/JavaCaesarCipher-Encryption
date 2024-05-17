import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextAnalyzerCLI {
  /**
     * Displays a menu of functionality options for specific analysis.
     * Allows the user to select an option and returns the chosen option.
     *
     * @return The selected functionality option.
     */
    private static int functionalityMenu() {
        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("Please select an option to proceed:");
            System.out.println("-------------------------------------");
            System.out.println("1. Average Word Length");
            System.out.println("2. Letter Frequency");
            System.out.println("3. Word Density");
            System.out.println("4. Contains Only Letters");
            System.out.println("5. Contains Numbers");
            System.out.println("6. Contains Word");
            System.out.println("7. Count Alphabetic Characters");
            System.out.println("8. Count Characters");
            System.out.println("9. Count Consonants");
            System.out.println("10. Count Lines");
            System.out.println("0. Next");
            System.out.print("Your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("!!!Invalid input. Please enter an integer.!!!");
                scanner.next();
            }
            int option = scanner.nextInt();
            scanner.nextLine();
            
            if (option >= 1 && option <= 29) {
                return option;
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
                continue;
            }
        }
        while (true) {
            System.out.println("\n-------------------------------------\n");
            System.out.println("11. Count Lowercase Letters");
            System.out.println("12. Count Numeric Characters");
            System.out.println("13. Count Sentence Occurrences");
            System.out.println("14. Count Sentences");
            System.out.println("15. Count Spaces");
            System.out.println("16. Count Special Characters");
            System.out.println("17. Count Uppercase Letters");
            System.out.println("18. Count Vowels");
            System.out.println("19. Count Word Occurrences");
            System.out.println("20. Count Words");
            System.out.println("0. Next");
            System.out.print("Your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("!!!Invalid input. Please enter an integer.!!!");
                scanner.next();
            }
            int option = scanner.nextInt();
            scanner.nextLine();
            
            if (option >= 1 && option <= 29) {
                return option;
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
                continue;
            }
        }
        while (true) {
            System.out.println("\n-------------------------------------\n");
            System.out.println("21. Count Words Ending With Letter");
            System.out.println("22. Count Words Of Length");
            System.out.println("23. Count Words Starting With Letter");
            System.out.println("24. Find Longest Word");
            System.out.println("25. Find Most Common Word");
            System.out.println("26. Find Palindromes");
            System.out.println("27. Find Shortest Word");
            System.out.println("28. Is Pangram");
            System.out.println("29. Return");
            System.out.print("Your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("!!!Invalid input. Please enter an integer.!!!");
                scanner.next();
            }
            int option = scanner.nextInt();
            scanner.nextLine();
            
            if (option >= 1 && option <= 29) {
                return option;
            } else {
                System.out.println("!!!Invalid option. Please try again.!!!");
                continue;
            }
        }
    }
}
