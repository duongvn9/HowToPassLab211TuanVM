package program;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
class Validate {
    static boolean checkDuplicate(ArrayList<Student> studentList, Student newStudent, int currentIndexStudent, boolean message) {
        boolean isDuplicate = false;
        for (int i = 0; i < studentList.size(); i++) {
            // check if i index equal current student index
            if (i == currentIndexStudent) {
                continue;
            }
            Student student = studentList.get(i);
            if (newStudent.getId().equals(student.getId())
                    && newStudent.getSemester().equalsIgnoreCase(student.getSemester())
                    && newStudent.getCourseName().equals(student.getCourseName())) {
                isDuplicate = true;
                if (message) {
                    System.out.println("Student duplicated. Please enter again!");
                }
                break;
            }
        }
        return isDuplicate;
    }

    // overload to check display message
    static boolean checkDuplicate(ArrayList<Student> studentList, Student newStudent) {
        return checkDuplicate(studentList, newStudent, -1, true);
    }

    // overload to check display message and ignore current student
    static boolean checkDuplicate(ArrayList<Student> studentList, Student newStudent, int currentIndexStudent) {
        return checkDuplicate(studentList, newStudent, currentIndexStudent, true);
    }

    static boolean checkIDUnique(ArrayList<Student> studentList, Student newStudent) {
        boolean isNotUnique = false;
        // Loop each student in student list
        for (Student student : studentList) {
            // check if id is equal
            if (newStudent.getId().equalsIgnoreCase(student.getId())) {
                // when the name is not equal
                if (!newStudent.getStudentName().equalsIgnoreCase(student.getStudentName())) {
                    System.out.println("ID is not unique. Please enter again");
                    isNotUnique = true;
                    break;
                }
            }
        }
        return isNotUnique;
    }

}