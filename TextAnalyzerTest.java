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

}
