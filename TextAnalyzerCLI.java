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
     * Performs a complete analysis of the provided text, displaying various metrics and characteristics.
     *
     * @param text The text to be analyzed.
     */
    private static void completeAnalysis(String text) {
        System.out.println("-------------------------------------");
        System.out.println("\n=> " + text);
        System.out.println("\n");
        
        System.out.println("1. Average Word Length => " + textAnalyzer.averageWordLength(text));
        System.out.println("2. Letter Frequency => " + textAnalyzer.calculateLetterFrequency(text));
        System.out.println("3. Word Density => " + textAnalyzer.calculateWordDensity(text));
        System.out.println("4. Contains Only Letters => " + textAnalyzer.containsOnlyLetters(text));
        System.out.println("5. Contains Numbers => " + textAnalyzer.containsNumbers(text));
        System.out.println("6. Count Alphabetic Characters => " + textAnalyzer.countAlphabeticCharacters(text));
        System.out.println("7. Count Characters => " + textAnalyzer.countCharacters(text));
        System.out.println("8. Count Consonants => " + textAnalyzer.countConsonants(text));
        System.out.println("9. Count Lines => " + textAnalyzer.countLines(text));
        System.out.println("10. Count Lowercase Letters => " + textAnalyzer.countLowercaseLetters(text));
        System.out.println("11. Count Numeric Characters => " + textAnalyzer.countNumericCharacters(text));
        System.out.println("12. Count Sentences => " + textAnalyzer.countSentences(text));
        System.out.println("13. Count Spaces => " + textAnalyzer.countSpaces(text));
        System.out.println("14. Count Special Characters => " + textAnalyzer.countSpecialCharacters(text));
        System.out.println("15. Count Uppercase Letters => " + textAnalyzer.countUppercaseLetters(text));
        System.out.println("16. Count Vowels => " + textAnalyzer.countVowels(text));
        System.out.println("17. Count Words => " + textAnalyzer.countWords(text));
        System.out.println("18. Find Longest Word => " + textAnalyzer.findLongestWord(text));
        System.out.println("19. Find Most Common Word => " + textAnalyzer.findMostCommonWord(text));
        System.out.println("20. Find Palindromes => " + textAnalyzer.findPalindromes(text));
        System.out.println("21. Find Shortest Word => " + textAnalyzer.findShortestWord(text));
        System.out.println("22. Is Pangram => " + textAnalyzer.isPangram(text));
    }

    /**
     * Performs specific analysis of the provided text based on user-selected options.
     * Displays various metrics and characteristics corresponding to the selected analysis option.
     *
     * @param text The text to be analyzed.
     */
    private static void specificAnalysis(String text) {
        String word, sentence;
        char letter;
        int length;

        int option = functionalityMenu();
        System.out.println("\n");
        switch (option) {
            case 1:
                System.out.println("1. Average Word Length => " + textAnalyzer.averageWordLength(text));
                break;
            case 2:
                System.out.println("2. Letter Frequency => " + textAnalyzer.calculateLetterFrequency(text));
                break;
            case 3:
                System.out.println("3. Word Density => " + textAnalyzer.calculateWordDensity(text));
                break;
            case 4:
                System.out.println("4. Contains Only Letters => " + textAnalyzer.containsOnlyLetters(text));
                break;
            case 5:
                System.out.println("5. Contains Numbers => " + textAnalyzer.containsNumbers(text));
                break;
            case 6:
                System.out.println("Enter a word: ");
                word = scanner.nextLine();
                System.out.println("6. Contains Word => " + textAnalyzer.containsWord(text, word));
                break;
            case 7:
                System.out.println("7. Count Alphabetic Characters => " + textAnalyzer.countAlphabeticCharacters(text));
                break;
            case 8:
                System.out.println("8. Count Characters => " + textAnalyzer.countCharacters(text));
                break;
            case 9:
                System.out.println("9. Count Consonants => " + textAnalyzer.countConsonants(text));
                break;
            case 10:
                System.out.println("10. Count Lines => " + textAnalyzer.countLines(text));
                break;
            case 11:
                System.out.println("11. Count Lowercase Letters => " + textAnalyzer.countLowercaseLetters(text));
                break;
            case 12:
                System.out.println("12. Count Numeric Characters => " + textAnalyzer.countNumericCharacters(text));
                break;
            case 13:
                System.out.println("Enter sentence: ");
                sentence = scanner.nextLine();
                System.out.println("13. Count Sentence Occurrences => " + textAnalyzer.countSentenceOccurrences(text, sentence));
                break;
            case 14:
                System.out.println("14. Count Sentences => " + textAnalyzer.countSentences(text));
                break;
            case 15:
                System.out.println("15. Count Spaces => " + textAnalyzer.countSpaces(text));
                break;
            case 16:
                System.out.println("16. Count Special Characters => " + textAnalyzer.countSpecialCharacters(text));
                break;
            case 17:
                System.out.println("17. Count Uppercase Letters => " + textAnalyzer.countUppercaseLetters(text));
                break;
            case 18:
                System.out.println("18. Count Vowels => " + textAnalyzer.countVowels(text));
                break;
            case 19:
                System.out.println("Enter word: ");
                word = scanner.nextLine();
                System.out.println("19. Count Word Occurrences => " + textAnalyzer.countWordOccurrences(text, word));
                break;
            case 20:
                System.out.println("20. Count Words => " + textAnalyzer.countWords(text));
                break;
            case 21:
                System.out.println("Enter letter: ");
                letter = scanner.nextLine().charAt(0);
                System.out.println("21. Count Words Ending With Letter => " + textAnalyzer.countWordsEndingWithLetter(text, letter));
                break;
            case 22:
                System.out.println("Enter length: ");
                length = scanner.nextInt();
                System.out.println("22. Count Words Of Length => " + textAnalyzer.countWordsOfLength(text, length));
                break;
            case 23:
                System.out.println("Enter letter: ");
                letter = scanner.nextLine().charAt(0);
                System.out.println("23. Count Words Starting With Letter => " + textAnalyzer.countWordsStartingWithLetter(text, letter));
                break;
            case 24:
                System.out.println("24. Find Longest Word => " + textAnalyzer.findLongestWord(text));
                break;
            case 25:
                System.out.println("25. Find Most Common Word => " + textAnalyzer.findMostCommonWord(text));
                break;
            case 26:
                System.out.println("26. Find Palindromes => " + textAnalyzer.findPalindromes(text));
                break;
            case 27:
                System.out.println("27. Find Shortest Word => " + textAnalyzer.findShortestWord(text));
                break;
            case 28:
                System.out.println("28. Is Pangram => " + textAnalyzer.isPangram(text));
                break;
            default:
                return;
        }
        System.out.println("\n");
        System.out.println("-------------------------------------");
        System.out.println("Do you want to continue as is or enter a different text:");
        System.out.println("-------------------------------------");
        System.out.println("\t1. Continue");
        System.out.println("\t2. Return");
        System.out.print("Your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("!!!Invalid input. Please enter an integer.!!!");
            scanner.next();
        }
        int option_2 = scanner.nextInt();
        scanner.nextLine();
        
        switch (option_2) {
            case 1:
                specificAnalysis(text);
                break;
            default:
                return;
        }
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