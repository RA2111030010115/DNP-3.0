import java.util.Scanner;

public class NoteApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriterDemo fileWriterDemo = new FileWriterDemo();
        FileReaderDemo fileReaderDemo = new FileReaderDemo();

        System.out.print("Enter a note: ");
        String note = scanner.nextLine();

        String fileName = "note.txt";
        fileWriterDemo.saveNoteToFile(fileName, note);
        fileReaderDemo.readNoteFromFile(fileName);

        scanner.close();
    }
}
