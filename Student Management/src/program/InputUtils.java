package program;

import java.util.Scanner;

class InputUtils {
    static Scanner sc = new Scanner(System.in);

    static int inputMenuChoice() {
        String input;
        int number;
        // loop infinity
        while (true) {
            try {
                System.out.print("Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program: ");
                input = sc.nextLine();
                // check if input is empty
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again!");
                    // loop until get string input
                    continue;
                }
                number = Integer.parseInt(input);
                // check if input is out of range 1;5
                if (number < 1 || number > 5) {
                    System.out.println("Please input number in range [1,5]");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in range [1,5]");
            }
        }
        return number;
    }

    static int inputValidInteger(String msg, String outOfRangeMsg, int min, int max) {
        String input;
        int number = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(msg);
            input = sc.nextLine();
            // check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input can not null. Please enter again!");
                continue;
            }
            try {
                number = Integer.parseInt(input);
                if (number < min || number > max) {
                    isValid = false;
                    System.out.println(outOfRangeMsg);
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(outOfRangeMsg);
            }
        }
        return number;
    }

    static String inputID() {
        String input;
        // loop infinity
        while (true) {
            System.out.print("Please input ID: ");
            input = sc.nextLine();
            // check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input can not null. Please enter again!");
                // loop until get string input
                continue;
            } else {
                break;
            }
        }
        return input;
    }

    static String inputName() {
        String input;
        // loop infinity
        while (true) {
            System.out.print("Please input name: ");
            input = sc.nextLine();
            // check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input can not null. Please enter again!");
                // loop until get string input
                continue;
            } else {
                break;
            }
        }
        return input;
    }

    static String inputSemester() {
        String input;
        // loop infinity
        while (true) {
            System.out.print("Please input semester: ");
            input = sc.nextLine();
            // check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input can not null. Please enter again!");
                // loop until get string input
                continue;
            } else {
                break;
            }
        }
        return input;
    }

    static String inputCourseName() {
        String courseName;
        int choice;
        // loop infinity
        while (true) {
            try {
                System.out.print("Please enter the course name (1. Java, 2. Net, 3. C/c++): ");
                courseName = sc.nextLine();
                // check if input is empty
                if (courseName.isEmpty()) {
                    System.out.println("Input can not null. Please enter again!");
                    continue;
                }
                choice = Integer.parseInt(courseName);
                if (choice < 1 || choice > 3) {
                    System.out.println("Please input number in range [1,3]");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in range [1,3]");
            }
        }
        switch (choice) {
            case 1:
                courseName = "Java";
                break;
            case 2:
                courseName = ".Net";
                break;
            case 3:
                courseName = "C/c++";
                break;
        }
        return courseName;
    }

    static String inputConfirm(String choice1, String choice2) {
        String input = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Please confirm: ");
            input = sc.nextLine();
            // check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input can not null. Please enter again!");
                continue;
            }
            if (input.equalsIgnoreCase(choice1) || input.equalsIgnoreCase(choice2)) {
                isValid = true;
            } else {
                System.out.println("Wrong confirm. Please enter " + choice1 + " or " + choice2);
                isValid = false;
            }
        }
        return input;
    }
}