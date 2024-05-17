import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextAnalyzerCLI {
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
}
