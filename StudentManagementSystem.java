import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    static class Student {
        private String firstName;
        private String lastName;

        public Student(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndEditStudentByFullName();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void enterStudentList() {
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter first name of student " + (i + 1) + ": ");
            String firstName = scanner.nextLine().trim();
            System.out.print("Enter last name of student " + (i + 1) + ": ");
            String lastName = scanner.nextLine().trim();
            students.add(new Student(firstName, lastName));
        }
        System.out.println("Student list entered successfully.");
    }
    private static void findStudentsByLastName() {
        System.out.print("Enter the last name to search for: ");
        String lastName = scanner.nextLine().trim();
        boolean found = false;

        for (Student student : students) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Found: " + student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found with the last name: " + lastName);
        }
    }
    private static void findAndEditStudentByFullName() {
        System.out.print("Enter the first name to search for: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter the last name to search for: ");
        String lastName = scanner.nextLine().trim();
        boolean found = false;

        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(firstName) &&
                    student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Student found: " + student);
                System.out.print("Enter new first name: ");
                String newFirstName = scanner.nextLine().trim();
                System.out.print("Enter new last name: ");
                String newLastName = scanner.nextLine().trim();
                student.setFirstName(newFirstName);
                student.setLastName(newLastName);
                System.out.println("Student information updated successfully. Updated student: " + student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No students found with the full name: " + firstName + " " + lastName);
        }
    }
}