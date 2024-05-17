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
public void testCountLines() {
    // Test case 1: Basic case with multiple lines
    String text1 = "Line 1\nLine 2\nLine 3";
    assertEquals(3, textAnalyzer.countLines(text1));

    // Test case 2: Case with single line
    String text2 = "Single line";
    assertEquals(1, textAnalyzer.countLines(text2));

    // Test case 3: Case with empty text
    String text3 = "";
    try {
        textAnalyzer.countLines(text3);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }

    // Test case 4: Case with null text
    String text4 = null;
    try {
        textAnalyzer.countLines(text4);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }

    // Test case 5: Case with mixed characters and newlines
    String text5 = "Line 1\nLine 2\r\nLine 3\rLine 4";
    assertEquals(3, textAnalyzer.countLines(text5));
}
  @Test
public void testCountLowercaseLetters() {
    // Test case 1: Basic case with lowercase letters
    String text1 = "lowercase text";
    assertEquals(13, textAnalyzer.countLowercaseLetters(text1));

    // Test case 2: Case with uppercase letters only
    String text2 = "UPPERCASE TEXT";
    assertEquals(0, textAnalyzer.countLowercaseLetters(text2));

    // Test case 3: Case with mixed lowercase and uppercase letters
    String text3 = "MixedCase Text";
    assertEquals(10, textAnalyzer.countLowercaseLetters(text3));

    // Test case 4: Case with numbers and symbols
    String text4 = "123 Symbols #";
    assertEquals(6, textAnalyzer.countLowercaseLetters(text4));

    // Test case 5: Case with empty text
    String text5 = "";
    try {
        textAnalyzer.countLowercaseLetters(text5);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }

    // Test case 6: Case with null text
    String text6 = null;
    try {
        textAnalyzer.countLowercaseLetters(text6);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }
}


  @Test
public void testCountNumericCharacters() {
    // Test case 1: Basic case with numeric characters
    String text1 = "123 Numeric 456";
    assertEquals(6, textAnalyzer.countNumericCharacters(text1));

    // Test case 2: Case with alphanumeric characters
    String text2 = "Alphanumeric123";
    assertEquals(3, textAnalyzer.countNumericCharacters(text2));

    // Test case 3: Case with symbols and special characters
    String text3 = "!@#$%^&*()";
    assertEquals(0, textAnalyzer.countNumericCharacters(text3));

    // Test case 4: Case with empty text
    String text4 = "";
    try {
        textAnalyzer.countNumericCharacters(text4);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }

    // Test case 5: Case with null text
    String text5 = null;
    try {
        textAnalyzer.countNumericCharacters(text5);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }
}
  @Test
public void testCountSentenceOccurrences() {
    // Test case 1: Basic case with multiple occurrence
    String text1 = "This is a test sentence. Another test sentence.";
    String sentence1 = "test sentence";
    assertEquals(2, textAnalyzer.countSentenceOccurrences(text1, sentence1));

    // Test case 2: Case with one occurrences
    String text2 = "One. Two. Three. Four. Five.";
    String sentence2 = "Three.";
    assertEquals(1, textAnalyzer.countSentenceOccurrences(text2, sentence2));

    // Test case 3: Case with no occurrence
    String text3 = "No occurrences here.";
    String sentence3 = "test";
    assertEquals(0, textAnalyzer.countSentenceOccurrences(text3, sentence3));

    // Test case 4: Case with empty text
    String text4 = "";
    String sentence4 = "test";
    try {
        textAnalyzer.countSentenceOccurrences(text4, sentence4);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }

    // Test case 5: Case with null text
    String text5 = null;
    String sentence5 = "test";
    try {
        textAnalyzer.countSentenceOccurrences(text5, sentence5);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }
}

    @Test
    public void testCountWordsEndingWithLetter() {
        // Test case 1: Basic case with single word ending with the specified letter
        String text1 = "Hello";
        assertEquals(1, textAnalyzer.countWordsEndingWithLetter(text1, 'o'));
    
        // Test case 2: Case with multiple words, one of which ends with the specified letter
        String text2 = "Hello World!";
        assertEquals(1, textAnalyzer.countWordsEndingWithLetter(text2, 'o'));
    
        // Test case 3: Case with multiple words, none of which end with the specified letter
        String text3 = "Hello World";
        assertEquals(0, textAnalyzer.countWordsEndingWithLetter(text3, 'f'));
    
        // Test case 4: Case with no words (empty string)
        String text4 = "";
        try {
            textAnalyzer.countWordsEndingWithLetter(text4, 'o');
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 5: Case with null text
        String text5 = null;
        try {
            textAnalyzer.countWordsEndingWithLetter(text5, 'o');
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
    
}
