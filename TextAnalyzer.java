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
}
