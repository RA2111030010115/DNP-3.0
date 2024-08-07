import java.nio.file.*;
import java.io.IOException;
import java.util.Scanner;

public class BackupApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter source directory path: ");
        String sourceDirStr = scanner.nextLine();
        Path sourceDir = Paths.get(sourceDirStr);

        System.out.print("Enter target directory path: ");
        String targetDirStr = scanner.nextLine();
        Path targetDir = Paths.get(targetDirStr);

        try {
            Files.createDirectories(targetDir);
            DirectoryCopy.copyDirectory(sourceDir, targetDir);
        } catch (IOException e) {
            System.err.println("Failed to create target directory: " + e.getMessage());
        }

        scanner.close();
    }
}
