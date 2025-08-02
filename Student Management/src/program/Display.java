package program;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
class Display {
    static void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "\t1. Create\n"
                + "\t2. Find and Sort\n"
                + "\t3. Update/Delete\n"
                + "\t4. Report\n"
                + "\t5. Exit"
        );
    }

    static void displayAddedStudentList(ArrayList<Student> studentList) {
        System.out.println("=== Added Student List ===");
        System.out.printf("|%-5s|%-20s|%-10s|%-20s|\n", "ID", "Student Name", "Semester", "Course Name");
        for (Student student : studentList) {
            student.displayStudentInfo();
        }
    }

    static void displayFoundStudentList(ArrayList<Student> studentFound) {
        System.out.println("=== Found And Sorted Student List ===");
        System.out.printf("|%-20s|%-10s|%-20s|\n", "Student Name", "Semester", "Course Name");
        System.out.println("-------------------------------------------------");
        // loop each student in studentFound list
        for (Student student : studentFound) {
            System.out.printf("|%-20s|%-10s|%-20s|\n", student.getStudentName(), student.getSemester(), student.getCourseName());
        }
    }

}