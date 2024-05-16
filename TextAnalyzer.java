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

}
