import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TextAnalyzer {
    /**
     * Calculates the average length of words in the given text.
     * 
     * @param text The text to analyze.
     * @return The average length of words.
     */
    public int averageWordLength(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Split the text into words using non-alphabetic characters as delimiter
        String[] words = text.split("\\W+");
    
        // Initialize variables to store total characters and total words
        int totalCharacters = 0;
        int totalWords = 0;
    
        // Calculate total characters in all words and total number of words
        for (String word : words) {
            if (!word.isEmpty()) { // Exclude empty strings
                totalCharacters += word.length();
                totalWords++;
            }
        }
    
        // Calculate average word length
        return totalWords > 0 ? Math.round((float) totalCharacters / totalWords) : 0;
    }

    /**
     * Calculates the frequency of each letter in the given text.
     * 
     * @param text The text to analyze.
     * @return A map containing each letter and its frequency.
     */
    public Map<Character, Integer> calculateLetterFrequency(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Create a map to store letter frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
    
        // Convert the text to lowercase to ignore case sensitivity
        text = text.toLowerCase();
    
        // Iterate through each character in the text
        for (char c : text.toCharArray()) {
            // Check if the character is a letter
            if (Character.isLetter(c)) {
                // Update the frequency map
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }
    
        return frequencyMap;
    }

}
