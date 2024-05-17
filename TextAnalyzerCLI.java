import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextAnalyzerCLI {
    private static TextAnalyzer textAnalyzer = new TextAnalyzer(); // Instance of TextAnalyzer for text analysis
    private static Scanner scanner = new Scanner(System.in); // Scanner object for user input

    /**
     * Entry point of the program.
     * Displays a menu for the user to select options to either enter text directly or provide a text file.
     * After obtaining the text, it offers further options for complete or specific analysis.
     */
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("       Welcome to Text Analyzer      ");
        System.out.println("=====================================\n");

        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("Please select an option to proceed:");
            System.out.println("\t1. Enter text directly");
            System.out.println("\t2. Provide a text file");
            System.out.println("\t3. Exit");
            System.out.print("Your choice: ");

            // Validate input for menu option
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
            int option = scanner.nextInt();
            scanner.nextLine();

            String text = "";
            switch (option) {
                case 1:
                    System.out.print("Please enter the text: ");
                    text = scanner.nextLine();
                    System.out.println("-------------------------------------");
                    System.out.println("\nThe provided text is:");
                    System.out.println("=> " + text + "\n");
                    break;
                case 2:
                    System.out.println("-------------------------------------");
                    System.out.print("Please enter the file path: ");
                    String filePath = scanner.nextLine();
                    try {
                        text = readFromFile(filePath);
                        System.out.println("-------------------------------------");
                        System.out.println("\nThe content of the file is:");
                        System.out.println("=> " + text + "\n");
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: File not found. Please check the file path and try again.");
                        continue;
                    }
                    break;
                case 3:
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println("Thank you for using Text Analyzer. Goodbye!");
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    return;
                default:
                    System.out.println("!!!Invalid option. Please try again!!!");
                    continue;
            }
            
            while (true) {
                System.out.println("-------------------------------------");
                System.out.println("Please select an option to proceed:");
                System.out.println("\t1. Complete Analysis");
                System.out.println("\t2. Specific Analysis");
                System.out.println("\t3. Return");
                System.out.print("Your choice: ");
                
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next();
                }
                int option_2 = scanner.nextInt();
                scanner.nextLine();
    
                switch (option_2) {
                    case 1:
                        completeAnalysis(text);
                        break;
                    case 2:
                        specificAnalysis(text);
                        break;
                    case 3:
                        System.out.println("<=<=<=Returning to previous menu.");
                        break;
                    default:
                        System.out.println("!!!Invalid option. Please try again.!!!");
                        continue;
                }
                break;
            }
        }
    }

    /**
     * Reads text from a file specified by the provided file path.
     *
     * @param filePath The path of the file to read text from.
     * @return A string containing the text read from the file.
     * @throws FileNotFoundException If the file specified by the filePath does not exist or cannot be opened for reading.
     */
    private static String readFromFile(String filePath) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            text.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return text.toString();
    }

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