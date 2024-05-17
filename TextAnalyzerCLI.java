import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextAnalyzerCLI {
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

}
