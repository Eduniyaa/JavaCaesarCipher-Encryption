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

}
