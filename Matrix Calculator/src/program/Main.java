package program;

/**
 * @author pc
 */
public class Main {

    public static void main(String[] args) {
        // Step 1: Display menu
        DisplayUtils.displayMenu();

        // Step 2: Perform function based on the selected option
        int choice = InputUtils.inputChoice("Your choice: ");

        switch (choice) {
            case 1 -> // Process Addition
                ProcessMatrix.processAddOrSubtract("+");
            case 2 -> // Process Subtraction
                ProcessMatrix.processAddOrSubtract("-");
            case 3 -> // Process MUltiplication
                ProcessMatrix.processMultiplication();
            case 4 -> // Exit
                System.exit(0);
        }

    }
}
