import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        ArrayList<Fruit> fruitList = new ArrayList<>();
        Hashtable<Customer, ArrayList<Order>> orderList = new Hashtable<>();

        FruitManagement manager = new FruitManagement();
        int choice;
        boolean isExit = false;

        do {
            // Step1: Display menu
            displayMenu();
            // Step2: Get choice from user
            choice = GetData.getValidChoice("Please enter input (from 1 to 4): ",
                    "Input must be in range from 1 to 4. Please re-enter!", 1, 4);
            // Step 3: Do user choice
            switch (choice) {
                // Function 1: Create fruit
                case 1:
                    manager.createFruit(fruitList);
                    break;
                // Function 2: View orders
                case 2:
                    manager.viewOrder(orderList);
                    break;
                // Function 3: Shopping (for buyer)
                case 3:
                    manager.shoppingForBuyer(fruitList, orderList);
                    break;
                // Function 4: Exit
                case 4:
                    System.out.println("\nProgram closed. Goodbye!");
                    isExit = true;
            }
        } // loop if not exit
        while (!isExit);
    }

    public static void displayMenu() {
        System.out.println("\nFRUIT SHOP SYSTEM\n"
                + "\n"
                + "     1. Create Fruit\n"
                + "     2. View Orders\n"
                + "     3. Shopping (for buyer)\n"
                + "     4. Exit\n"
                + "\n"
                + "(Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).\n");
    }
}