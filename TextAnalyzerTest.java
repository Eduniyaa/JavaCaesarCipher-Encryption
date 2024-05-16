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

    @Test
    public void testCountAlphabeticCharacters() {
        // Test case 1: Basic case with alphabetic characters
        String text1 = "This is a test with 123 numbers";
        assertEquals(22, textAnalyzer.countAlphabeticCharacters(text1));
    
        // Test case 2: Case with only alphabetic characters
        String text2 = "OnlyAlphabeticCharacters";
        assertEquals(24, textAnalyzer.countAlphabeticCharacters(text2));
    
        // Test case 3: Case with no alphabetic characters
        String text3 = "1234567890";
        assertEquals(0, textAnalyzer.countAlphabeticCharacters(text3));
    
        // Test case 4: Case with empty text
        String text4 = "";
        try {
            textAnalyzer.countAlphabeticCharacters(text4);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 5: Case with null text
        String text5 = null;
        try {
            textAnalyzer.countAlphabeticCharacters(text5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCountCharacters() {
        // Test case 1: Basic case with characters
        String text1 = "This is a test.";
        assertEquals(15, textAnalyzer.countCharacters(text1));
    
        // Test case 2: Case with empty text
        String text2 = "";
        try {
            textAnalyzer.countCharacters(text2);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 3: Case with null text
        String text3 = null;
        try {
            textAnalyzer.countCharacters(text3);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 4: Case with special characters
        String text4 = "!@#$%^&*()_+";
        assertEquals(12, textAnalyzer.countCharacters(text4));
    
        // Test case 5: Case with numbers
        String text5 = "1234567890";
        assertEquals(10, textAnalyzer.countCharacters(text5));
    }

}
