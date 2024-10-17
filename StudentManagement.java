import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentManagement {
    private List<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student);
    }

    // Edit an existing student's details
    public void editStudent(int id, String newName, double newMarks) {
        Student student = searchStudentById(id);
        if (student != null) {
            student.setName(newName);
            student.setMarks(newMarks);
            System.out.println("Student updated: " + student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        Student student = searchStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted: " + student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Search for a student by ID
    public Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Sort students by marks
    public void sortStudentsByMarks() {
        Collections.sort(students, Comparator.comparingDouble(Student::getMarks));
        System.out.println("Students sorted by marks.");
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
