import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TextAnalyzer {
  
    /**
     * Counts the total number of lines in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of lines.
     */
    public int countLines(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Split the text into lines using the newline character as delimiter
        String[] lines = text.split("\\r?\\n");
    
        // Return the total number of lines
        return lines.length;
    }
   /**
     * Counts the total number of lowercase letters in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of lowercase letters.
     */
    public int countLowercaseLetters(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Initialize a counter for lowercase letters
        int count = 0;
    
        // Iterate through each character in the text
        for (char c : text.toCharArray()) {
            // Check if the character is a lowercase letter
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
    
        return count;
    }

    /**
     * Counts the total number of numeric characters in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of numeric characters.
     */
    public int countNumericCharacters(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Initialize a counter for numeric characters
        int count = 0;
    
        // Iterate through each character in the text
        for (char c : text.toCharArray()) {
            // Check if the character is a numeric character
            if (Character.isDigit(c)) {
                count++;
            }
        }
    
        return count;
    }
    
    
    /**
     * Counts the occurrences of a specific sentence in the given text.
     * 
     * @param text The text to search.
     * @param sentence The sentence to count occurrences for.
     * @return The number of occurrences of the sentence.
     */
    public int countSentenceOccurrences(String text, String sentence) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence cannot be null or empty.");
        }
    
        // Initialize a counter for sentence occurrences
        int count = 0;
    
        // Search for sentence occurrences in the text
        int index = text.indexOf(sentence);
        while (index != -1) {
            count++;
            index = text.indexOf(sentence, index + 1);
        }
    
        return count;
    }
    
}
