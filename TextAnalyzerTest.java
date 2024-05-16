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
}
