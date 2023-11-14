
import java.util.ArrayList;
import java.util.List;

public class Dict {

    public class GroceryInventorySystem {
        public void main(String[] args) {
            // Create a list of Dict objects
            List<Dict> inventory = new ArrayList<>();
            inventory.add(new Dict("Apple", 1.99, 10));
            inventory.add(new Dict("Bread", 2.49, 5));
            inventory.add(new Dict("Milk", 3.29, 8));

            // Print out the list of items
            for (Dict item : inventory) {
                System.out.println(item);
            }
        }
    }

    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Dict(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter methods (you can add setters if needed)
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}
