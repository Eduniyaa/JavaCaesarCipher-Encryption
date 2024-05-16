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
    public void testContainsNumbers() {
        // Test case 1: Basic case with numbers
        String text1 = "12345";
        assertTrue(textAnalyzer.containsNumbers(text1));

        // Test case 2: Case with no numbers
        String text2 = "This does not contain any numbers";
        assertFalse(textAnalyzer.containsNumbers(text2));

        // Test case 3: Case with mixed characters
        String text3 = "This contains 123 numbers and some letters";
        assertTrue(textAnalyzer.containsNumbers(text3));

        // Test case 4: Case with special characters
        String text4 = "!@#$%^&*()";
        assertFalse(textAnalyzer.containsNumbers(text4));

        // Test case 5: Case with empty text
        String text5 = "";
        try {
            textAnalyzer.containsNumbers(text5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testContainsWord() {
        // Test case 1: Basic case with word present
        String text1 = "This contains the word test";
        String word1 = "test";
        assertTrue(textAnalyzer.containsWord(text1, word1));

        // Test case 2: Case with word not present
        String text2 = "This does not contain the word eample";
        String word2 = "example";
        assertFalse(textAnalyzer.containsWord(text2, word2));
    
        // Test case 3: Case with word partially present
        String text3 = "This is a test";
        String word3 = "testing";
        assertFalse(textAnalyzer.containsWord(text3, word3));
    
        // Test case 4: Case with empty text
        String text4 = "";
        String word4 = "test";
        try {
            textAnalyzer.containsWord(text4, word4);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 5: Case with empty word
        String text5 = "This is a test";
        String word5 = "";
        try {
            textAnalyzer.containsWord(text5, word5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

}
