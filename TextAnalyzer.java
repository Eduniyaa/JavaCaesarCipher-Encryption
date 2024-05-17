import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TextAnalyzer {
   /**
     * Counts the total number of sentences in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of sentences.
     */
    public int countSentences(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Split the text into sentences using sentence-ending punctuation marks as delimiters
        String[] sentences = text.split("[.!?]+");
    
        // Return the total number of sentences
        return sentences.length;
    }
     /**
     * Counts the total number of spaces in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of spaces.
     */
    public int countSpaces(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null.");
        }
    
        // Initialize a counter for spaces
        int count = 0;
    
        // Iterate through each character in the text
        for (char c : text.toCharArray()) {
            // Check if the character is a space
            if (c == ' ') {
                count++;
            }
        }
    
        return count;
    }
   
    /**
     * Counts the total number of special characters in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of special characters.
     */
    public int countSpecialCharacters(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Initialize a counter for special characters
        int count = 0;
    
        // Iterate through each character in the text
        for (char c : text.toCharArray()) {
            // Check if the character is a special character
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                count++;
            }
        }
    
        return count;
    }

    /**
     * Counts the total number of uppercase letters in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of uppercase letters.
     */
    public int countUppercaseLetters(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Initialize a counter for uppercase letters
        int count = 0;
    
        // Iterate through each character in the text
        for (char c : text.toCharArray()) {
            // Check if the character is an uppercase letter
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
    
        return count;
    }
    /**
     * Counts the total number of vowels in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of vowels.
     */
    public int countVowels(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Convert the text to lowercase to ignore case sensitivity
        text = text.toLowerCase();
    
        // Initialize a counter for vowels
        int count = 0;
    
        // Iterate through each character in the text
        for (char c : text.toCharArray()) {
            // Check if the character is a vowel
            if (Character.isLetter(c) && "aeiou".indexOf(c) != -1) {
                count++;
            }
        }
    
        return count;
    }
    /**
     * Counts the number of words in the given text that have a specific length.
     * 
     * @param text The text to analyze.
     * @param length The length of words to count.
     * @return The number of words with the specified length.
     */
    public int countWordsOfLength(String text, int length) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
        if (length < 0) {
            throw new IllegalArgumentException("Word length cannot be negative.");
        }
    
        // Split the text into words using a regular expression that includes only alphabetic characters and apostrophes as delimiters
        String[] words = text.split("\\W+");
    
        // Initialize a counter for words of the specified length
        int count = 0;
    
        // Iterate through each word in the text
        for (String word : words) {
            // Check if the length of the word matches the specified length
            if (!word.isEmpty() && word.length() == length) {
                count++;
            }
        }
    
        return count;
    }
    

    

}
