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
       @Test
    public void testFindShortestWord() {
        // Test case 1: Basic case with one word
        String text1 = "This is a test.";
        String shortestWord1 = textAnalyzer.findShortestWord(text1);
        assertEquals("a", shortestWord1);
    
        // Test case 2: Basic case with multiple words
        String text2 = "The quick brown fox jumps over the lazy dog.";
        String shortestWord2 = textAnalyzer.findShortestWord(text2);
        assertEquals("The", shortestWord2);
    
        // Test case 3: Empty string
        String text3 = "";
        try {
            textAnalyzer.findShortestWord(text3);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 4: Single word
        String text4 = "Hello";
        String shortestWord4 = textAnalyzer.findShortestWord(text4);
        assertEquals("Hello", shortestWord4);
    
        // Test case 5: Shortest word in the middle
        String text5 = "The cat is on the mat.";
        String shortestWord5 = textAnalyzer.findShortestWord(text5);
        assertEquals("is", shortestWord5);
    }
   @Test
    public void testFindPalindromes() {
        // Test case 1: Basic case with a single palindrome
        String text1 = "Able was I ere I saw Elba";
        List<String> expected1 = Arrays.asList("ere");
        assertEquals(expected1, textAnalyzer.findPalindromes(text1));
    
        // Test case 2: Case with no palindrome
        String text2 = "Hello World";
        List<String> expected2 = new ArrayList<>();
        assertEquals(expected2, textAnalyzer.findPalindromes(text2));
    
        // Test case 3: Case with mixed-case palindrome
        String text3 = "Abba";
        List<String> expected3 = Arrays.asList("Abba");
        assertEquals(expected3, textAnalyzer.findPalindromes(text3));
    
        // Test case 4: Case with multiple palindromes
        String text4 = "A man, a plan, a canal, Panama!";
        List<String> expected4 = new ArrayList<>();
        assertEquals(expected4, textAnalyzer.findPalindromes(text4));
    
        // Test case 5: Case with null text
        String text5 = null;
        try {
            textAnalyzer.findPalindromes(text5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

@Test
    public void testFindMostCommonWord() {
        // Test case 1: Basic case with single word
        String text1 = "Hello";
        assertEquals("Hello", textAnalyzer.findMostCommonWord(text1));
    
        // Test case 2: Case with multiple words, one of which is the most common
        String text2 = "Hello World! Hello";
        assertEquals("Hello", textAnalyzer.findMostCommonWord(text2));
    
        // Test case 3: Case with multiple words, where there are multiple words with the same frequency
        String text3 = "Hello World Hello World!";
        assertEquals("Hello", textAnalyzer.findMostCommonWord(text3));
    
        // Test case 4: Case with no words (empty string)
        String text4 = "";
        try {
            textAnalyzer.findMostCommonWord(text4);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 5: Case with null text
        String text5 = null;
        try {
            textAnalyzer.findMostCommonWord(text5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
    @Test
    public void testFindLongestWord() {
        // Test case 1: Basic case with single word
        String text1 = "Hello";
        assertEquals("Hello", textAnalyzer.findLongestWord(text1));
    
        // Test case 2: Case with multiple words, one of which is the longest
        String text2 = "Hello World!";
        assertEquals("Hello", textAnalyzer.findLongestWord(text2));
    
        // Test case 3: Case with multiple words, where there are two longest words
        String text3 = "Hello World";
        assertEquals("Hello", textAnalyzer.findLongestWord(text3));
    
        // Test case 4: Case with no words (empty string)
        String text4 = "";
        try {
            textAnalyzer.findLongestWord(text4);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 5: Case with null text
        String text5 = null;
        try {
            textAnalyzer.findLongestWord(text5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
