import java.util.ArrayList;

public class CheckData {
    static boolean checkIdUniqueFruit(ArrayList<Fruit> fruitList, Fruit newFruit) {
        boolean isNotUnique = false;

        // Loop each fruit in fruitList
        for (Fruit fruit : fruitList) {
            // Check if same fruit id
            if (newFruit.getFruitId().equalsIgnoreCase(fruit.getFruitId())) {
                isNotUnique = true;
                break;
            }
        }

        return isNotUnique;
    }


}