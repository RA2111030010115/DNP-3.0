import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LargeFileReader {
    public void readLargeFile(String inputFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line (for demonstration, we will just print the line)
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
