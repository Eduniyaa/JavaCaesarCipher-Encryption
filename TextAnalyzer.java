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
/**
     * Finds all palindromes in the given text.
     * 
     * @param text The text to analyze.
     * @return A list of palindromes found in the text.
     */
    public List<String> findPalindromes(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Split the text into words using a regular expression that includes only alphabetic characters as delimiters
        String[] words = text.split("\\W+");
    
        // Initialize a list to store palindromes
        List<String> palindromes = new ArrayList<>();
    
        // Iterate through each word in the text
        for (String word : words) {
            // Remove punctuation from the word
            word = word.replaceAll("[^a-zA-Z]", "");
            // Check if the word is a palindrome (case insensitive)
            if (!word.isEmpty() && isPalindrome(word.toLowerCase()) && word.length() != 1) {
                palindromes.add(word);
            }
        }
            return palindromes;
    }
// Helper method to check if a string is a palindrome (case insensitive)
    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
    
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
    
        return true;
    }
   /**
     * Finds the most common word in the given text.
     * 
     * @param text The text to analyze.
     * @return The most common word.
     */
    public String findMostCommonWord(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Split the text into words using whitespace as delimiter
        String[] words = text.split("\\W+");
    
        // Create a map to store word frequencies
        Map<String, Integer> wordFrequencies = new HashMap<>();
    
        // Populate the map with word frequencies
        for (String word : words) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }
    
        // Initialize variables to track the most common word and its frequency
        String mostCommonWord = "";
        int maxFrequency = 0;
    
        // Find the most common word
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostCommonWord = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
    
        return mostCommonWord;
    }
   /**
     * Finds the longest word in the given text.
     * 
     * @param text The text to analyze.
     * @return The longest word.
     */
    public String findLongestWord(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Split the text into words using a regular expression that includes only alphabetic characters and apostrophes as delimiters
        String[] words = text.split("\\W+");
    
        // Initialize a variable to store the longest word
        String longestWord = "";
    
        // Iterate through each word in the text
        for (String word : words) {
            // Check if the current word is longer than the current longest word
            if (!word.isEmpty() && word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
    
        return longestWord;
    }
      /**
     * Counts the occurrences of a specific word in the given text.
     * 
     * @param text The text to search.
     * @param word The word to count occurrences for.
     * @return The number of occurrences of the word.
     */
    public int countWordOccurrences(String text, String word) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty.");
        }
    
        // Convert text and word to lowercase
        text = text.toLowerCase();
        word = word.toLowerCase();
    
        // Split the text into words using non-alphabetic characters and apostrophes as delimiters,
        // but exclude apostrophes used in quotations
        String[] words = text.split("\\W+");
    
        // Initialize a counter for word occurrences
        int count = 0;
    
        // Iterate through each word in the text
        for (String w : words) {
            // Check if the word matches the specified word (case insensitive)
            if (w.equals(word)) {
                count++;
            }
        }
    
        return count;
    }

}
