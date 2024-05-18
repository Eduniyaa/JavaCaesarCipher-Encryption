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

    @Test
    public void testCountWordOccurrences() {
        // Test case 1: Basic case with single occurrence
        String text1 = "Hello World!";
        assertEquals(1, textAnalyzer.countWordOccurrences(text1, "hello"));
    
        // Test case 2: Case with multiple occurrences
        String text2 = "Java is a programming language. Java is widely used.";
        assertEquals(2, textAnalyzer.countWordOccurrences(text2, "java"));
    
        // Test case 3: Case with no occurrences
        String text3 = "This is a test.";
        assertEquals(0, textAnalyzer.countWordOccurrences(text3, "hello"));
    
        // Test case 4: Case with empty text
        String text4 = "";
        try {
            textAnalyzer.countWordOccurrences(text4, "hello");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 5: Case with null text
        String text5 = null;
        try {
            textAnalyzer.countWordOccurrences(text5, "hello");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 6: Case with empty word
        String text6 = "This is a test.";
        try {
            textAnalyzer.countWordOccurrences(text6, "");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCountWords() {
        // Test case 1: Basic case with single word
        String text1 = "Hello";
        assertEquals(1, textAnalyzer.countWords(text1));
    
        // Test case 2: Case with multiple words
        String text2 = "Hello World!";
        assertEquals(2, textAnalyzer.countWords(text2));
    
        // Test case 3: Case with no words (empty string)
        String text3 = "";
        try {
            textAnalyzer.countWords(text3);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 4: Case with null text
        String text4 = null;
        try {
            textAnalyzer.countWords(text4);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 5: Case with text containing only whitespaces
        String text5 = "      ";
        assertEquals(0, textAnalyzer.countWords(text5));
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
    
    @Test
    public void testCountWordsOfLength() {
        // Test case 1: Basic case with single word of the specified length
        String text1 = "Hello";
        assertEquals(1, textAnalyzer.countWordsOfLength(text1, 5));
    
        // Test case 2: Case with multiple words, some of which have the specified length
        String text2 = "Hello Worlds!";
        assertEquals(1, textAnalyzer.countWordsOfLength(text2, 5));
    
        // Test case 3: Case with multiple words, none of which have the specified length
        String text3 = "Hello World";
        assertEquals(0, textAnalyzer.countWordsOfLength(text3, 7));
    
        // Test case 4: Case with no words (empty string)
        String text4 = "";
        try {
            textAnalyzer.countWordsOfLength(text4, 5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 5: Case with null text
        String text5 = null;
        try {
            textAnalyzer.countWordsOfLength(text5, 5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 6: Case with negative word length
        String text6 = "Hello World";
        try {
            textAnalyzer.countWordsOfLength(text6, -5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCountWordsStartingWithLetter() {
        // Test case 1: Basic case with single word starting with the specified letter
        String text1 = "Hello";
        assertEquals(1, textAnalyzer.countWordsStartingWithLetter(text1, 'H'));
    
        // Test case 2: Case with multiple words, some of which start with the specified letter
        String text2 = "Hello World!";
        assertEquals(1, textAnalyzer.countWordsStartingWithLetter(text2, 'W'));
    
        // Test case 3: Case with multiple words, none of which start with the specified letter
        String text3 = "hello world";
        assertEquals(0, textAnalyzer.countWordsStartingWithLetter(text3, 'r'));
    
        // Test case 4: Case with no words (empty string)
        String text4 = "";
        try {
            textAnalyzer.countWordsStartingWithLetter(text4, 'H');
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    
        // Test case 5: Case with null text
        String text5 = null;
        try {
            textAnalyzer.countWordsStartingWithLetter(text5, 'H');
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