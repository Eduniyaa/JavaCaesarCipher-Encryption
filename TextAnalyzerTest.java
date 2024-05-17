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
    private TextAnalyzer textAnalyzer; // Global variable for TextAnalyzer

    @Before
    public void setUp() {
        textAnalyzer = new TextAnalyzer(); // Initialize TextAnalyzer before each test
    }

    @Test
    public void testAverageWordLength() {
        // Test case 1: a single word
        assertEquals(5, textAnalyzer.averageWordLength("Hello"));

        // Test case 2: multiple words
        assertEquals(4, textAnalyzer.averageWordLength("The quick brown fox"));

        // Test case 3: punctuation and special characters
        assertEquals(5, textAnalyzer.averageWordLength("Hello, world!"));

        // Test case 4: empty text
        try {
            textAnalyzer.averageWordLength("");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        // Test case 5: null text
        try {
            textAnalyzer.averageWordLength(null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCalculateLetterFrequency() {
        // Test case 1: Basic case with a simple text
        String text1 = "Hello, World!";
        Map<Character, Integer> result1 = textAnalyzer.calculateLetterFrequency(text1);
        Map<Character, Integer> expected1 = new HashMap<>();
        expected1.put('h', 1);
        expected1.put('e', 1);
        expected1.put('l', 3);
        expected1.put('o', 2);
        expected1.put('w', 1);
        expected1.put('r', 1);
        expected1.put('d', 1);
        assertEquals(expected1, result1);

        // Test case 2: Case with repeated letters
        String text2 = "Mississippi";
        Map<Character, Integer> result2 = textAnalyzer.calculateLetterFrequency(text2);
        Map<Character, Integer> expected2 = new HashMap<>();
        expected2.put('m', 1);
        expected2.put('i', 4);
        expected2.put('s', 4);
        expected2.put('p', 2);
        assertEquals(expected2, result2);

        // Test case 3: Case with no alphabetic characters
        String text3 = "12345";
        Map<Character, Integer> result3 = textAnalyzer.calculateLetterFrequency(text3);
        Map<Character, Integer> expected3 = new HashMap<>();
        assertEquals(expected3, result3);
    
        // Test case 4: Case with special characters
        String text4 = "!@a#$%^g&*(cfg)";
        Map<Character, Integer> result4 = textAnalyzer.calculateLetterFrequency(text4);
        Map<Character, Integer> expected4 = new HashMap<>();
        expected4.put('a', 1);
        expected4.put('g', 2);
        expected4.put('c', 1);
        expected4.put('f', 1);
        assertEquals(expected4, result4);
        assertEquals(expected4, result4);
    }

    @Test
    public void testCalculateWordDensity() {
        // Test case 1: Basic case with a simple sentence
        String text1 = "This is a simple sentence.";
        assertEquals(5, textAnalyzer.calculateWordDensity(text1));

        // Test case 2: Case with multiple sentences
        String text2 = "This is a simple sentence. Another sentence follows!";
        assertEquals(4, textAnalyzer.calculateWordDensity(text2));

        // Test case 3: Case with empty text
        String text3 = "";
        try {
            textAnalyzer.calculateWordDensity(text3);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        // Test case 4: Case with special characters
        String text4 = "!@#$%^&*()";
        assertEquals(0, textAnalyzer.calculateWordDensity(text4));
    }

}