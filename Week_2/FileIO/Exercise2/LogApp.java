import java.util.Arrays;

public class LogApp {

    public static void main(String[] args) {
        String fileName = "logfile.txt";
        LogWriter logWriter = new LogWriter();
        LogReader logReader = new LogReader();

        
        logWriter.writeLog(fileName, "Log message 1");
        logWriter.writeLog(fileName, "Log message 2");
        logWriter.writeLog(fileName, "Log message 3");

        
        logReader.readLogs(fileName);

        
        String nonExistentFile = "nonexistentfile.txt";
        System.out.println("\nAttempting to read from a non-existent file...");
        logReader.readLogs(nonExistentFile);
    }
}
