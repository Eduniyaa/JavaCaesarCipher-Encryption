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
}