import java.util.Scanner;

public class StudentGradesTest {
    public static void main(String[] args) {
        StudentGrades studentGrades = new StudentGrades();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Grades Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student Grade");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Student Grade (A-F): ");
                    char grade = scanner.nextLine().charAt(0);

                    Student student = new Student(id, name, grade);
                    studentGrades.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter Student ID to remove: ");
                    int studentId = scanner.nextInt();
                    studentGrades.removeStudent(studentId);
                    break;

                case 3:
                    System.out.print("Enter Student ID to update grade: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter New Grade (A-F): ");
                    char newGrade = scanner.nextLine().charAt(0);

                    studentGrades.updateStudentGrade(updateId, newGrade);
                    break;

                case 4:
                    studentGrades.displayStudents();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
