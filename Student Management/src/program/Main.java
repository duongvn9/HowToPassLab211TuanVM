package program;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<>();

        int choice;

        boolean isExit = false;
        do {
            // Step 1: Display menu
            Display.displayMenu();
            // Step 2: Get choice from user
            choice = InputUtils.inputMenuChoice();
            // Step 3: Do user choice
            switch (choice) {
                case 1:
                    // Function 1: Create student
                    StudentManagement.createStudent(studentList);
                    break;
                case 2:
                    // Function 2: Find by id and sort by name or part of name
                    StudentManagement.findByIdAndSortByName(studentList);
                    break;
                case 3:
                    // Function 3: Update or delete
                    StudentManagement.updateOrDeleteById(studentList);
                    break;
                case 4:
                    // Function 4: Report course
                    StudentManagement.reportCourse(studentList);
                    break;
                case 5:
                    // Function 5: Exit
                    isExit = true;
                    break;
            }
            // Loop until isExit is true
        } while (!isExit);
    }
}