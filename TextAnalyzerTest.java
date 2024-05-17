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

}