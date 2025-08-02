/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author pc
 */
class StudentManagement {
    static Scanner sc = new Scanner(System.in);

    static void createStudent(ArrayList<Student> studentList) {
        String id;
        String studentName;
        String semester;
        String courseName;
        String confirmInput;
        boolean isDupID = false;
        boolean isDup = false;
        boolean isNotUnique = false;

        // check student list size > 10
        if (studentList.size() > 10) {
            System.out.print("There are already more than 10 student in list. "
                    + "Do you want to continue adding? (Y or N): ");
            confirmInput = InputUtils.inputConfirm("y", "n");
            if (confirmInput.equalsIgnoreCase("N")) {
                return;
            }
        }
        do {
            System.out.println("student " + (studentList.size() + 1) + ":");
            // get ID
            id = InputUtils.inputID().trim();
            // get name
            studentName = InputUtils.inputName().trim();
            // get semester
            semester = InputUtils.inputSemester().trim();
            // get course name
            courseName = InputUtils.inputCourseName().trim();
            Student newStudent = new Student(id, studentName, semester, courseName);

            // function check duplicate ID
            isNotUnique = Validate.checkIDUnique(studentList, newStudent);
            // function check ID unique
            if (isNotUnique) {
                continue;
            } else {
                isDup = Validate.checkDuplicate(studentList, newStudent);
                // check if duplicated
                if (isDup) {
                    continue;
                }
            }
            // if valid add to student list
            studentList.add(newStudent);
            Display.displayAddedStudentList(studentList);

            // check if list size > 10 to ask user
            if (studentList.size() > 10) {
                System.out.print("There are already more than 10 student in list. "
                        + "Do you want to continue adding? (Y or N): ");
                confirmInput = InputUtils.inputConfirm("y", "n");
                if (confirmInput.equalsIgnoreCase("N")) {
                    return;
                }
            }
        } while (true);
    }

    static void findByIdAndSortByName(ArrayList<Student> studentList) {
        ArrayList<Student> studentFound = new ArrayList<>();
        String partOfName;
        System.out.print("Please enter name of student to find: ");
        partOfName = sc.nextLine();

        // loop each student in student list
        for (Student student : studentList) {
            // check if student name to contain part of name
            if (student.getStudentName().toLowerCase().contains(partOfName.toLowerCase())) {
                studentFound.add(student);
            }
        }

        // check if not found student part of name
        if (studentFound.isEmpty()) {
            System.out.println("Not found any student!");
            return;
        }

        int length = studentFound.size();
        // sort student name in studentFound list from the first index
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (studentFound.get(i).getStudentName().compareTo(studentFound.get(j).getStudentName()) > 0) {
                    Collections.swap(studentFound, i, j);
                }
            }
        }
        // display found student list
        Display.displayFoundStudentList(studentFound);

        studentFound.clear();
    }

    static void updateOrDeleteById(ArrayList<Student> studentList) {
        HashMap<Integer, Integer> studentFound = new LinkedHashMap<>();
        String id;
        System.out.print("Please enter ID to found: ");
        id = sc.nextLine().trim();
        int length = studentList.size();
        for (int i = 0; i < length; i++) {
            if (studentList.get(i).getId().equals(id)) {
                studentFound.put(studentFound.size(), i);
            }
        }

        // check if not found any student
        if (studentFound.isEmpty()) {
            System.out.println("Not found any student!");
            return;
        }

        // loop each student in studentFound list
        for (Map.Entry<Integer, Integer> student : studentFound.entrySet()) {
            int valIndex = student.getValue();
            System.out.println("[" + (studentFound.size() > 1 ? valIndex : "0") + "]" + studentList.get(valIndex).toString());
        }

        int chooseStudent = InputUtils.inputValidInteger("Please choose student: ", "out of range. Please enter again!", 1, studentFound.size());
        String confirmInput = InputUtils.inputConfirm("u", "d");

        // check confirm is update
        if (confirmInput.equalsIgnoreCase("u")) {
            boolean isDupID = false;
            boolean isNotUnique = false;
            String updatedID;
            String updatedName;
            String updatedSemester;
            String updatedCourse;
            Student studentFoundObj = studentList.get(studentFound.get(chooseStudent));
            // check name not same in this id
            updatedID = InputUtils.inputID().trim();
            updatedName = InputUtils.inputName().trim();
            isNotUnique = false;
            for (int i = 0; i < studentList.size(); i++) {
                if (i == studentFound.get(chooseStudent)) continue;
                Student s = studentList.get(i);
                if (s.getId().equalsIgnoreCase(updatedID) && !s.getStudentName().equalsIgnoreCase(updatedName)) {
                    System.out.println("ID is not unique. Please re-enter");
                    isNotUnique = true;
                    break;
                }
            }
            if (isNotUnique) {
                return;
            }
            do {
                updatedSemester = InputUtils.inputSemester().trim();
                updatedCourse = InputUtils.inputCourseName().trim();
                // check for duplicate student (ignore itself when update)
                isDupID = Validate.checkDuplicate(studentList, new Student(updatedID, updatedName, updatedSemester, updatedCourse), studentFound.get(chooseStudent), false);
                if (isDupID) {
                    System.out.println("Student duplicated. Please enter again!");
                } else {
                    break;
                }
            } while (true);

            studentFoundObj.setId(updatedID);
            studentFoundObj.setStudentName(updatedName);
            studentFoundObj.setSemester(updatedSemester);
            studentFoundObj.setCourseName(updatedCourse);

            System.out.println("Update completed");
        } else if (confirmInput.equalsIgnoreCase("d")) {
            studentList.remove((int) studentFound.get(chooseStudent));
            System.out.println("Delete completed");
        }
    }

    static void reportCourse(ArrayList<Student> studentList) {
        System.out.printf("%-30s%-10s%-10s\n", "Student Name", "Course Name", "Total");
        courseCount("Java", studentList);
        courseCount(".Net", studentList);
        courseCount("C/c++", studentList);
    }

    private static void courseCount(String course, ArrayList<Student> studentList) {
        ArrayList<Student> studentCourseList = new ArrayList<>();
        int count;

        // loop each student in studentList for index
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            // check if student learn course
            if (student.getCourseName().equals(course)) {
                studentCourseList.add(student);
            }
        }

        boolean isAccept;
        // check if si is greater than 0
        for (int i = 0; i < studentCourseList.size(); i++) {
            isAccept = true;
            // loop each student before current in studentCourseList by index
            for (int k = 1; k < i; k++) {
                // check if same id with current
                if (studentCourseList.get(k).getId().equals(studentCourseList.get(i).getId())) {
                    isAccept = false;
                    break;
                }
            }
            // check if count accept
            if (isAccept) {
                count = 0;
                // loop each next student in studentCourseList
                for (int j = i; j < studentCourseList.size(); j++) {
                    // check if same id
                    if (studentCourseList.get(j).getId().equals(studentCourseList.get(i).getId())) {
                        count++;
                    }
                }
                System.out.printf("%-30s%-10s%-10d\n", studentCourseList.get(i).getStudentName(), studentCourseList.get(i).getCourseName(), count);
            }
        }
        studentCourseList.clear();
    }
}
