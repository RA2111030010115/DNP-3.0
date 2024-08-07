import java.nio.file.*;
import java.io.IOException;

public class FileCopy {

    public static void copyFile(Path source, Path target) {
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied from " + source + " to " + target);
        } catch (IOException e) {
            System.err.println("Failed to copy file: " + e.getMessage());
        }
    }
}
