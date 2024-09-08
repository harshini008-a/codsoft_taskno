/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author A .Harshini
 */
import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    int enrolled;
    String schedule;

    Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
        this.schedule = schedule;
    }

    boolean register() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        } else {
            System.out.println("Course is full.");
            return false;
        }
    }

    void drop() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    void displayCourseDetails() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled: " + enrolled);
        System.out.println("Schedule: " + schedule);
        System.out.println();
    }
}

class Student {
    String studentID;
    String name;
    ArrayList<Course> registeredCourses = new ArrayList<>();

    Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    void registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            System.out.println("You are already registered for this course.");
        } else if (course.register()) {
            registeredCourses.add(course);
            System.out.println("Successfully registered for " + course.title);
        }
    }

    void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.drop();
            System.out.println("Successfully dropped " + course.title);
        } else {
            System.out.println("You are not registered for this course.");
        }
    }

    void listRegisteredCourses() {
        System.out.println("Registered Courses for " + name + ":");
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            for (Course course : registeredCourses) {
                course.displayCourseDetails();
            }
        }
    }
}

public class CourseRegistrationSystem {
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Adding some sample courses
        courses.add(new Course("CS101", "Intro to Computer Science", "Basics of computer science", 3, "MWF 9AM-10AM"));
        courses.add(new Course("MATH201", "Calculus I", "Introduction to calculus", 2, "TTh 10AM-11:30AM"));
        courses.add(new Course("PHY101", "Physics I", "Fundamentals of Physics", 4, "MWF 11AM-12PM"));

        // Adding a sample student
        students.add(new Student("S001", "John Doe"));

        int choice;
        Student currentStudent = students.get(0);  // Assuming John Doe is logged in

        do {
            System.out.println("\nStudent Course Registration System:");
            System.out.println("1. List available courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. List registered courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // List available courses
                    System.out.println("\nAvailable Courses:");
                    for (Course course : courses) {
                        course.displayCourseDetails();
                    }
                    break;
                case 2:
                    // Register for a course
                    System.out.print("Enter the course code to register: ");
                    String courseCode = scanner.next();
                    Course courseToRegister = findCourseByCode(courseCode);
                    if (courseToRegister != null) {
                        currentStudent.registerCourse(courseToRegister);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 3:
                    // Drop a course
                    System.out.print("Enter the course code to drop: ");
                    String courseCodeToDrop = scanner.next();
                    Course courseToDrop = findCourseByCode(courseCodeToDrop);
                    if (courseToDrop != null) {
                        currentStudent.dropCourse(courseToDrop);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 4:
                    // List registered courses
                    currentStudent.listRegisteredCourses();
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

    static Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.courseCode.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}

