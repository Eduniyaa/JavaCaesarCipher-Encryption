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

    @Test
    public void testContainsOnlyLetters() {
        // Test case 1: Basic case with only letters
        String text1 = "ThisIsATest";
        assertTrue(textAnalyzer.containsOnlyLetters(text1));
    
        // Test case 2: Case with letters and spaces
        String text2 = "This Is A Test";
        assertFalse(textAnalyzer.containsOnlyLetters(text2));
    
        // Test case 3: Case with letters and numbers
        String text3 = "ThisIsA123Test";
        assertFalse(textAnalyzer.containsOnlyLetters(text3));
    
        // Test case 4: Case with special characters
        String text4 = "!@#$%^&*()";
        assertFalse(textAnalyzer.containsOnlyLetters(text4));
    
        // Test case 5: Case with empty text
        String text5 = "";
        try {
            textAnalyzer.containsOnlyLetters(text5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

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

    @Test
    public void testCountConsonants() {
        // Test case 1: Basic case with consonants
        String text1 = "Hello World";
        assertEquals(7, textAnalyzer.countConsonants(text1));

        // Test case 2: Case with no consonants
        String text2 = "aeiou";
        assertEquals(0, textAnalyzer.countConsonants(text2));

        // Test case 3: Case with empty text
        String text3 = "";
        try {
            textAnalyzer.countConsonants(text3);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        // Test case 4: Case with null text
        String text4 = null;
        try {
            textAnalyzer.countConsonants(text4);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 5: Case with mixed characters
        String text5 = "H3ll0 W0r1d";
        assertEquals(6, textAnalyzer.countConsonants(text5));
    }
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
