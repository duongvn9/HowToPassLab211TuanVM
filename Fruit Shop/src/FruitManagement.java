import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class FruitManagement {
    static Scanner sc = new Scanner(System.in);

    void createFruit(ArrayList<Fruit> fruitList) {
        String fruitId;
        String fruitName;
        float price;
        int quantity;
        String origin;

        boolean isContinue = false;
        boolean isNotUnique = false;

        do {
            System.out.println();

            // id - check unique immediately after input
            do {
                fruitId = GetData.getValidString("Enter fruit id: ").trim();
                // Create temporary fruit object to check ID uniqueness
                Fruit tempFruit = new Fruit(fruitId, "", 0, 0, "");
                isNotUnique = CheckData.checkIdUniqueFruit(fruitList, tempFruit);
                if (isNotUnique) {
                    System.out.println("Please enter a different fruit ID.");
                }
            } while (isNotUnique);

            // name
            fruitName = GetData.getValidString("Enter fruit name: ").trim();
            // price
            price = GetData.getValidPrice();
            // quantity
            quantity = GetData.getValidQuantity();
            // origin
            origin = GetData.getValidString("Enter fruit origin: ").trim();

            Fruit newFruit = new Fruit(fruitId, fruitName, price, quantity, origin);

            fruitList.add(newFruit);

            String confirmInput;
            System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.");
            confirmInput = GetData.getValidConfirm();

            // check if confirm is yes
            if (confirmInput.equalsIgnoreCase("Y")) {
                isContinue = true;
            } else {
                isContinue = false;
                System.out.printf("|%-8s|%-30s|%-30s|%-30s|%-30s|\n",
                        "Fruit id", "Fruit name", "Price", "Quantity", "Origin");

                // Display all fruits in the list
                for (Fruit fruit : fruitList) {
                    System.out.println(fruit.toString());
                }
            }
        } // check if continue
        while (isContinue);
    }

    void viewOrder(Hashtable<Customer, ArrayList<Order>> orderList) {
        // check if list is empty
        if (orderList.isEmpty()) {
            System.out.println("There no orders here!");
            return;
        }

        // loop each customer and their orders in orderList
        for (Map.Entry<Customer, ArrayList<Order>> entry : orderList.entrySet()) {
            Customer customer = entry.getKey();
            ArrayList<Order> orders = entry.getValue();
            int orderIndex = 0;
            for (Order order : orders) {
                orderIndex++;
                int count = 0;
                float total = 0;
                System.out.println("Customer: " + customer.getCustomerName() + " | Order #" + orderIndex);
                System.out.printf("%-5s|%-20s|%-20s|%-20s|%-20s\n", "No", "Product", "Quantity", "Price", "Amount");
                for (Fruit fruit : order.getFruits()) {
                    count++;
                    String fruitName = fruit.getFruitName();
                    int quantity = fruit.getQuantity();
                    float price = fruit.getPrice();
                    float amount = price * quantity;
                    total += amount;
                    String priceStr = String.format("%.2f", price) + "$";
                    String amountStr = String.format("%.2f", amount) + "$";
                    System.out.printf("%-5d%-20s|%-20d|%-20s|%-20s\n", count, fruitName, quantity, priceStr, amountStr);
                }
                System.out.println("Total: " + total + "$\n");
            }
        }
    }

    void shoppingForBuyer(ArrayList<Fruit> fruitList, Hashtable<Customer, ArrayList<Order>> orderList) {
        // check if fruit list is empty
        if (fruitList.isEmpty()) {
            System.out.println("There no products (fruits) to order!");
            return;
        }

        ArrayList<Fruit> orderedFruits = new ArrayList<>();
        Hashtable<Integer, Fruit> fruitDisplayList = new Hashtable<>();

        boolean isContinue = false;
        int choice;
        int maxChoice;
        String confirmInput;

        String customerName;
        String id;
        String fruitName;
        float price;
        int quantity;
        String origin;

        // Add fruits to display list with numbering
        for (int i = 0; i < fruitList.size(); i++) {
            fruitDisplayList.put(i + 1, fruitList.get(i));
        }

        maxChoice = fruitDisplayList.size();

        do {
            System.out.println("List of Fruits: ");
            System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");

            // Display all fruits in the list
            for (int i = 1; i <= fruitDisplayList.size(); i++) {
                Fruit fruit = fruitDisplayList.get(i);
                String priceStr = String.format("%.2f", fruit.getPrice()) + "$";
                System.out.printf("%-14d%-20s%-16s%-15s", i, fruit.getFruitName(), fruit.getOrigin(), priceStr);

                // Check if this fruit is sold out (quantity = 0)
                if (fruit.getQuantity() == 0) {
                    System.out.println("(Sold out!)");
                } else {
                    System.out.println();
                }
            }

            choice = GetData.getValidChoice("Enter your choice: ",
                    "(choice must be from 1 to " + maxChoice + ". Please re-enter)", 1, maxChoice);
            Fruit selectedFruit = fruitDisplayList.get(choice);

            System.out.println("You selected: " + selectedFruit.getFruitName());

            // Allow ordering even if quantity is 0
            quantity = GetData.getValidChoice("Please input quantity: ", ("Must not choose quantity greater than " +
                    selectedFruit.getFruitName() + "'s current quantity: " + selectedFruit.getQuantity()
                    + " or less than 0. Please re-enter!"), 0, selectedFruit.getQuantity());

            // Only update stock if quantity > 0
            if (quantity > 0) {
                selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
            }

            id = selectedFruit.getFruitId();
            fruitName = selectedFruit.getFruitName();
            price = selectedFruit.getPrice();
            origin = selectedFruit.getOrigin();

            Fruit newFruit = new Fruit(id, fruitName, price, quantity, origin);
            orderedFruits.add(newFruit);

            System.out.print(
                    "Do you want to order now (Y/N). If select N, continue ordering. If select Y, list of order will be displayed: ");
            confirmInput = GetData.getValidConfirm();

            // check if confirm is no (N)
            if (confirmInput.equalsIgnoreCase("N")) {
                isContinue = true;
            } else {
                isContinue = false;
            }
        } // loop if continue
        while (isContinue);

        // Check if any fruits with quantity > 0 were ordered
        boolean hasValidOrder = false;
        for (Fruit fruit : orderedFruits) {
            if (fruit.getQuantity() > 0) {
                hasValidOrder = true;
                break;
            }
        }

        if (!hasValidOrder) {
            System.out.println("No fruits with quantity > 0 were ordered. Shopping cancelled.");
            return;
        }

        customerName = GetData.getValidString("Input your name: ");

        // Create new customer and order
        Customer customer = new Customer(customerName);
        Order newOrder = new Order(customer, orderedFruits);

        if (orderList.containsKey(customer)) {
            orderList.get(customer).add(newOrder);
        } else {
            ArrayList<Order> orders = new ArrayList<>();
            orders.add(newOrder);
            orderList.put(customer, orders);
        }

        float amount;
        float total = 0;

        System.out.printf("%-20s|%-20s|%-20s|%-20s\n", "Product", "Quantity", "Price", "Amount");

        // Display order summary
        for (Fruit order : orderedFruits) {
            fruitName = order.getFruitName();
            quantity = order.getQuantity();
            price = order.getPrice();

            amount = price * quantity;
            total += amount;

            String priceStr = String.format("%.2f", price) + "$";
            String amountStr = String.format("%.2f", amount) + "$";

            System.out.printf("%-20s|%-20d|%-20s|%-20s\n", fruitName, quantity, priceStr, amountStr);
        }
        System.out.println("Total: " + total + "$");
    }
}