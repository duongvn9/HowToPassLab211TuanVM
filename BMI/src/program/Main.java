package program;

/**
 *
 * @author duongvnhe191516
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            // Step 1: Display menu
            CalculatorProgram.displayMainScreen();

            // Step 2: get user choice
            int choice = InputUtils.inputChoice();

            // Step 3: Handle by choice
            switch (choice) {
                case 1:
                    // Function 1: Normal Calculator
                    CalculatorProgram.normalCalculator();
                    break;
                case 2:
                    // Function 2: BMI calculator
                    CalculatorProgram.bmiCalculator();
                    break;
                case 3:
                    // exit
                    System.exit(0);
                    break;
            }
        }
    }
}