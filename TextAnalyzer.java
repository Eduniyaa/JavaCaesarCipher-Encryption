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
}
