package program;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class HandleData {
    private static final Scanner sc = new Scanner(System.in);

    private static double getInputData(String msg) {
        String inputString;
        double validNumber = 0;

        // loop infinity
        while (true) {
            try {
                // promt user to enter data
                System.out.print(msg);
                inputString = sc.nextLine();

                // check if input is null
                if (inputString.isEmpty()) {
                    System.out.println("Input cannot null. Please enter again!");
                    // loop until user enter anything
                    continue;
                }

                validNumber = Double.parseDouble(inputString);

                // check number is 0 or negative
                if (validNumber <= 0) {
                    System.out.println("Please enter positive number!");
                    // loop until get valid number
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a double number!");
            }
        }
        return validNumber;
    }

    static Rectangle getDataRectangle() {
        double width = getInputData("Please input side width of Rectangle: ");
        double length = getInputData("Please input length of Rectangle: ");

        // loop infinity
        while (true) {
            // check if user input width smaller than length
            if (width < length) {
                break;
            } else {
                System.out.println("Width should smaller than length. Please enter again.");
                // ask user enter again
                width = getInputData("Please input side width of Rectangle: ");
                length = getInputData("Please input length of Rectangle: ");
            }
        }

        // create new object rectangle
        Rectangle rectangle = new Rectangle(width, length);
        return rectangle;
    }

    static Circle getDataCircle() {
        double radius = getInputData("Please input radius of Circle: ");
        // create new object circle
        Circle circle = new Circle(radius);
        return circle;
    }

    static Triangle getDataTriangle() {
        double sideA = getInputData("Please input side A of Triangle: ");
        double sideB = getInputData("Please input side B of Triangle: ");
        double sideC = getInputData("Please input side C of Triangle: ");

        // loop infinity
        while (true) {
            // check condition of triangle: any two sides must be greater than another one.
            if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
                break;
            } else {
                System.out.println("Any two sides must be greater than another one.");
                System.out.println("Please enter again!");
                // ask user enter again
                sideA = getInputData("Please input side A of Triangle: ");
                sideB = getInputData("Please input side B of Triangle: ");
                sideC = getInputData("Please input side C of Triangle: ");
            }
        }

        // create new object triangle
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        return triangle;
    }

    // method to return output
    static void displayResult(Rectangle rectangle, Circle circle, Triangle triangle) {
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}