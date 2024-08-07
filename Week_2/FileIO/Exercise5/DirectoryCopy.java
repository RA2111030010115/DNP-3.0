import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Stream;

public class DirectoryCopy {

    public static void copyDirectory(Path sourceDir, Path targetDir) {
        try (Stream<Path> stream = Files.walk(sourceDir)) {
            stream.forEach(sourcePath -> {
                Path targetPath = targetDir.resolve(sourceDir.relativize(sourcePath));
                try {
                    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println("Failed to copy: " + sourcePath + " to " + targetPath + ": " + e.getMessage());
                }
            });
            System.out.println("Directory copied from " + sourceDir + " to " + targetDir);
        } catch (IOException e) {
            System.err.println("Failed to walk through source directory: " + e.getMessage());
        }
    }
}
