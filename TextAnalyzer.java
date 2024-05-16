import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TextAnalyzer {
    /**
     * Checks if the given text contains any numeric characters.
     * 
     * @param text The text to analyze.
     * @return True if the text contains numbers, otherwise false.
     */
    public boolean containsNumbers(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Check if the text contains any numeric characters
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
    
        return false;
    }

    /**
     * Checks if the given text contains a specific word.
     * 
     * @param text The text to search.
     * @param word The word to search for.
     * @return True if the word is found, otherwise false.
     */
    public boolean containsWord(String text, String word) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty.");
        }
    
        // Check if the text contains the specified word
        return text.contains(word);
    }

    /**
     * Counts the total number of alphabetic characters in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of alphabetic characters.
     */
    public int countAlphabeticCharacters(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Initialize a counter for alphabetic characters
        int count = 0;
    
        // Iterate through each character in the text
        for (char c : text.toCharArray()) {
            // Check if the character is alphabetic
            if (Character.isLetter(c)) {
                count++;
            }
        }
    
        return count;
    }

    /**
     * Counts the total number of characters in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of characters.
     */
    public int countCharacters(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null.");
        }
    
        // Return the length of the text
        return text.length();
    }

    /**
     * Counts the total number of consonants in the given text.
     * 
     * @param text The text to analyze.
     * @return The total number of consonants.
     */
    public int countConsonants(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Convert the text to lowercase to ignore case sensitivity
        text = text.toLowerCase();
    
        // Initialize a counter for consonants
        int count = 0;
    
        // Iterate through each character in the text
        for (char c : text.toCharArray()) {
            // Check if the character is a consonant
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) {
                count++;
            }
        }
    
        return count;
    }

}
