import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextAnalyzerCLI {
    /**
     * Reads text from a file specified by the provided file path.
     *
     * @param filePath The path of the file to read text from.
     * @return A string containing the text read from the file.
     * @throws FileNotFoundException If the file specified by the filePath does not exist or cannot be opened for reading.
     */
    private static String readFromFile(String filePath) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            text.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return text.toString();
    }

}