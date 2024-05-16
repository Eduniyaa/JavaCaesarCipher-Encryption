import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TextAnalyzerTest {
   @Test
    public void testIsPangram() {
        // Test case 1: Basic pangram
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        assertTrue(textAnalyzer.isPangram(pangram1));
    
        // Test case 2: Pangram with uppercase letters
        String pangram2 = "Pack my box with five dozen liquor jugs.";
        assertTrue(textAnalyzer.isPangram(pangram2));
    
        // Test case 3: Pangram with mixed case letters
        String pangram3 = "The five boxing wizards jump quickly.";
        assertTrue(textAnalyzer.isPangram(pangram3));
    
        // Test case 4: Non-pangram
        String nonPangram = "The quick brown fox jumps over the lazy cat.";
        assertFalse(textAnalyzer.isPangram(nonPangram));
    
        // Test case 5: Empty string
        String emptyString = "";
        try {
            textAnalyzer.isPangram(emptyString);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
