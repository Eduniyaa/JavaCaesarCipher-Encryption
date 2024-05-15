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

    /**
     * Calculates the word density (words per sentence) in the given text.
     * 
     * @param text The text to analyze.
     * @return The word density of the text.
     */
    public int calculateWordDensity(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Count the number of words
        int numWords = text.split("\\W+").length;
    
        // Count the number of sentences
        int numSentences = text.split("[.!?]+").length;
    
        // Calculate word density (words per sentence)
        return numSentences > 0 ? Math.round((float) numWords / numSentences) : 0;
    }
    
    /**
     * Checks if the given text contains only letters (alphabetic characters).
     * 
     * @param text The text to analyze.
     * @return True if the text contains only letters, otherwise false.
     */
    public boolean containsOnlyLetters(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
    
        // Check if every character in the text is a letter
        for (char c : text.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
    
        return true;
    }

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
