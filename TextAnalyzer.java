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
    
}
