package studentgradetracker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class representing the grade management system
public class GradeManagementSystem {
    private Map<String, Student> students; // Map to store students with their names as keys

    // Constructor to initialize the students map
    public GradeManagementSystem() {
        students = new HashMap<>();
    }

    // Method to create a new student and add to the map
    public Student createStudent(String name) {
        Student student = new Student(name); // Create new student object
        students.put(name, student); // Add student to the map
        return student; // Return the created student
    }

    // Method to retrieve a student by name
    public Student getStudent(String name) {
        return students.get(name); // Get student from the map
    }

    // Main method to run the grade management system
    public static void main(String[] args) {
        GradeManagementSystem gms = new GradeManagementSystem(); // Create grade management system object
        Scanner scanner = new Scanner(System.in); // Scanner object for user input
        boolean exit = false; // Flag to control the loop

        // Loop to keep the program running until user decides to exit
        while (!exit) {
            // Display the menu options
            System.out.println("\nStudent Grade Management System:");
            System.out.println("1. Create Student");
            System.out.println("2. Add Grade");
            System.out.println("3. View Student Grades");
            System.out.println("4. Calculate Average Grade");
            System.out.println("5. Display Overall Grade");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine();  // Consume newline

            // Switch case to handle user's choice
            switch (choice) {
                case 1:
                    // Case to create a new student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine(); // Read student name
                    Student student = gms.createStudent(name); // Create student
                    System.out.println("Student created: " + student.getName()); // Confirm creation
                    break;
                case 2:
                    // Case to add a grade to a student
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine(); // Read student name
                    Student studentToAddGrade = gms.getStudent(studentName); // Get student
                    if (studentToAddGrade != null) {
                        System.out.print("Enter subject: ");
                        String subject = scanner.nextLine(); // Read subject
                        System.out.print("Enter score: ");
                        double score = scanner.nextDouble(); // Read score
                        studentToAddGrade.addGrade(new Grade(subject, score)); // Add grade to student
                        System.out.println("Grade added: " + subject + " - " + score); // Confirm addition
                    } else {
                        System.out.println("Student not found."); // Student not found
                    }
                    break;
                case 3:
                    // Case to view grades of a student
                    System.out.print("Enter student name: ");
                    String studentNameToView = scanner.nextLine(); // Read student name
                    Student studentToView = gms.getStudent(studentNameToView); // Get student
                    if (studentToView != null) {
                        System.out.println("Grades for " + studentToView.getName() + ":");
                        for (Grade grade : studentToView.getGrades()) {
                            System.out.println(grade); // Display each grade
                        }
                    } else {
                        System.out.println("Student not found."); // Student not found
                    }
                    break;
                case 4:
                    // Case to calculate the average grade of a student
                    System.out.print("Enter student name: ");
                    String studentNameToCalculate = scanner.nextLine(); // Read student name
                    Student studentToCalculate = gms.getStudent(studentNameToCalculate); // Get student
                    if (studentToCalculate != null) {
                        double average = studentToCalculate.calculateAverage(); // Calculate average
                        System.out.println("Average grade for " + studentToCalculate.getName() + ": " + average); // Display average
                    } else {
                        System.out.println("Student not found."); // Student not found
                    }
                    break;
                case 5:
                    // Case to display overall grade information of a student
                    System.out.print("Enter student name: ");
                    String studentNameToDisplay = scanner.nextLine(); // Read student name
                    Student studentToDisplay = gms.getStudent(studentNameToDisplay); // Get student
                    if (studentToDisplay != null) {
                        System.out.println(studentToDisplay); // Display overall grade information
                    } else {
                        System.out.println("Student not found."); // Student not found
                    }
                    break;
                case 6:
                    // Case to exit the program
                    exit = true; // Set exit flag to true
                    break;
                default:
                    // Case for invalid choice
                    System.out.println("Invalid choice."); // Display error message
            }
        }

        scanner.close(); // Close the scanner
    }
}
