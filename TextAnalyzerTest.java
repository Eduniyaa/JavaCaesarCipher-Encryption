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

}
