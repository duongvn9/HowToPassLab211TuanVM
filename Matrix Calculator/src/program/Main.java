package program;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DisplayUtils.displayMenu();
        int choice = InputUtils.inputChoice("Your choice: ");

        switch (choice) {
            case 1:
                ProcessMatrix.processAddOrSubtract("+");
                break;
            case 2:
                ProcessMatrix.processAddOrSubtract("-");
                break;
            case 3:
                ProcessMatrix.processMultiplication();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}
