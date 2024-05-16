import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TextAnalyzer {
  /**
     * Checks if the given text is a pangram (contains every letter of the alphabet).
     * 
     * @param text The text to analyze.
     * @return True if the text is a pangram, otherwise false.
     */
    public boolean isPangram(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Convert the text to lowercase to ignore case sensitivity
        text = text.toLowerCase();
    
        // Initialize an array to track the presence of each letter
        boolean[] alphabet = new boolean[26];
    
        // Iterate through each character in the text
        for (char c : text.toCharArray()) {
            // Check if the character is a letter
            if (Character.isLetter(c)) {
                // Mark the corresponding index in the array for the letter
                alphabet[c - 'a'] = true;
            }
        }
    
        // Check if all letters of the alphabet are present
        for (boolean present : alphabet) {
            if (!present) {
                return false;
            }
        }
    
        return true;
    }
  /**
     * Finds the shortest word in the given text.
     * 
     * @param text The text to analyze.
     * @return The shortest word.
     */
    public String findShortestWord(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Split the text into words using whitespace as delimiter
        String[] words = text.split("\\W+");
    
        // Initialize a variable to store the shortest word
        String shortestWord = words[0];
    
        // Iterate through each word in the text
        for (String word : words) {
            // Check if the current word is shorter than the current shortest word
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }
    
        return shortestWord;
    }

}
