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
public void testCountSentences() {
    // Test case 1: Basic case with three sentences
    String text1 = "This is a sentence. This is another sentence! And a third one?";
    assertEquals(3, textAnalyzer.countSentences(text1));

    // Test case 2: Case with only one sentence
    String text2 = "Only one sentence here.";
    assertEquals(1, textAnalyzer.countSentences(text2));

    // Test case 3: Case with empty text
    String text3 = "";
    try {
        textAnalyzer.countSentences(text3);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }

    // Test case 4: Case with null text
    String text4 = null;
    try {
        textAnalyzer.countSentences(text4);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }
}
  
@Test
public void testCountSpaces() {
    // Test case 1: Basic case with spaces between words
    String text1 = "This is a test sentence.";
    assertEquals(4, textAnalyzer.countSpaces(text1));

    // Test case 2: Case with no spaces
    String text2 = "NoSpacesHere";
    assertEquals(0, textAnalyzer.countSpaces(text2));

    // Test case 3: Case with multiple spaces
    String text3 = "   Too   many   spaces   ";
    assertEquals(12, textAnalyzer.countSpaces(text3));

    // Test case 4: Case with empty text
    String text4 = "";
    try {
        textAnalyzer.countSpaces(text4);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }

    // Test case 5: Case with null text
    String text5 = null;
    try {
        textAnalyzer.countSpaces(text5);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }
}
@Test
public void testCountSpecialCharacters() {
    // Test case 1: Basic case with special characters
    String text1 = "Hello! How are you?";
    assertEquals(2, textAnalyzer.countSpecialCharacters(text1));

    // Test case 2: Case with no special characters
    String text2 = "NoSpecialCharacters";
    assertEquals(0, textAnalyzer.countSpecialCharacters(text2));

    // Test case 3: Case with multiple special characters
    String text3 = "!@#$%^&*()_+";
    assertEquals(12, textAnalyzer.countSpecialCharacters(text3));

    // Test case 4: Case with empty text
    String text4 = "";
    try {
        textAnalyzer.countSpecialCharacters(text4);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }

    // Test case 5: Case with null text
    String text5 = null;
    try {
        textAnalyzer.countSpecialCharacters(text5);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }
}

@Test
public void testCountUppercaseLetters() {
    // Test case 1: Basic case with uppercase letters
    String text1 = "Hello World!";
    assertEquals(2, textAnalyzer.countUppercaseLetters(text1));

    // Test case 2: Case with no uppercase letters
    String text2 = "hello world!";
    assertEquals(0, textAnalyzer.countUppercaseLetters(text2));

    // Test case 3: Case with all uppercase letters
    String text3 = "ALL UPPERCASE";
    assertEquals(12, textAnalyzer.countUppercaseLetters(text3));

    // Test case 4: Case with empty text
    String text4 = "";
    try {
        textAnalyzer.countUppercaseLetters(text4);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }

    // Test case 5: Case with null text
    String text5 = null;
    try {
        textAnalyzer.countUppercaseLetters(text5);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }
}
  @Test
public void testCountVowels() {
    // Test case 1: Basic case with vowels
    String text1 = "Hello World!";
    assertEquals(3, textAnalyzer.countVowels(text1));

    // Test case 2: Case with no vowels
    String text2 = "hll wrld!";
    assertEquals(0, textAnalyzer.countVowels(text2));

    // Test case 3: Case with all vowels
    String text3 = "aeiouAEIOU";
    assertEquals(10, textAnalyzer.countVowels(text3));

    // Test case 4: Case with empty text
    String text4 = "";
    try {
        textAnalyzer.countVowels(text4);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }

    // Test case 5: Case with null text
    String text5 = null;
    try {
        textAnalyzer.countVowels(text5);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
        assertTrue(true);
    }
}

}
