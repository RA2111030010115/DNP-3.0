import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LargeFileReader fileReader = new LargeFileReader();
        LargeFileWriter fileWriter = new LargeFileWriter();

        System.out.print("Enter the input file name: ");
        String inputFileName = scanner.nextLine();

        // Read the file and process the data
        List<String> processedData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Example processing: convert to upper case (replace with actual processing logic)
                processedData.add(line.toUpperCase());
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        System.out.print("Enter the output file name: ");
        String outputFileName = scanner.nextLine();

        // Write the processed data to the output file
        fileWriter.writeProcessedData(outputFileName, processedData);

        // Demonstrate error handling
        System.out.println("Attempting to read a non-existent file:");
        fileReader.readLargeFile("non_existent_file.txt");

        System.out.println("Attempting to write to a restricted directory:");
        fileWriter.writeProcessedData("/restricted_directory/output.txt", processedData);

        scanner.close();
    }
}
