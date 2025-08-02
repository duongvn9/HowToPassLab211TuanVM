/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package changebase;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        boolean isContinue = false;
        do {
            // Step 1: Required user choose the base number input
            int baseInput = InputUtils.getValidBase("Please choose the base number input: ");
            // Step 2: Required user choose the base number output
            int baseOutput = InputUtils.getValidBase("Please choose the the base output: ");
            // Step 3: Required user enter the input value
            String inputValue = InputUtils.getValidValue(baseInput);
            // Step 4: ProgMain process
            String outputValue = BaseConverter.changeBase(baseInput, baseOutput, inputValue);
            BaseConverter.printOutputValue(baseInput, baseOutput, inputValue, outputValue);

            // check user want continue
            System.out.println("Do you want to continue? 1 is Yes, 0 is No");
            choice = InputUtils.getValidChoice();
            // check if choice is 1
            if (choice == 1) {
                isContinue = true;
            }
            // check if choice is 0
            else if (choice == 0) {
                System.out.println("Exitting program...");
                // stop
                isContinue = false;
            }
        } while (isContinue);
    }
}
