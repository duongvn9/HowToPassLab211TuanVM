import java.util.ArrayList;

public class Order {
    private Customer customer;
    private ArrayList<Fruit> fruits;

    public Order(Customer customer, ArrayList<Fruit> fruits) {
        this.customer = customer;
        this.fruits = fruits;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }
}