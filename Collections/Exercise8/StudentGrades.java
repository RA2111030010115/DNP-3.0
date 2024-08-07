import java.util.LinkedHashMap;

public class StudentGrades {
    private LinkedHashMap<Integer, Student> students;

    public StudentGrades() {
        students = new LinkedHashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
        System.out.println("Student added: " + student);
    }

    public void removeStudent(int studentId) {
        Student removedStudent = students.remove(studentId);
        if (removedStudent != null) {
            System.out.println("Student removed: " + removedStudent);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void updateStudentGrade(int studentId, char newGrade) {
        Student student = students.get(studentId);
        if (student != null) {
            student.setGrade(newGrade);
            System.out.println("Grade updated for " + student);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students.values()) {
                System.out.println(student);
            }
        }
    }
}
