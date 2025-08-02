public class Fruit {
    private String fruitId;
    private String fruitName;
    private float price;
    private int quantity;
    private String origin;

    public Fruit(String fruitId, String fruitName, float price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        String priceStr = String.format("%.2f", price)+"$";
        String str = String.format("|%-8s|%-30s|%-30s|%-30d|%-30s|", fruitId, fruitName, priceStr, quantity, origin);
        return str;
    }
}