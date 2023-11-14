
// /*********************************************
//  Program: Inventory System
//  Author: Connor Hopkins
//  Purpose: This program will do the following--
//     - Add things to the inventory
//     - Remove things from the inventory
//     - Move items around the inventory
//  *********************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Dict {
        // Members
        private String name;
        private double price;
        private int quantity;

        // Constructor
        public Dict(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        // Getter and Setter methods
        public String getName() { return name; }

        public double getPrice() { return price; }

        public int getQuantity() { return quantity; }

        public void setName(String newName) { this.name = newName; }

        public void setPrice(double newPrice) { this.price = newPrice; }

        public void setQuantity(int newQuantity) { this.quantity = newQuantity; }

        @Override
        public String toString() {
            return "Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
        }
    }

    public static void displayInventory(List<Dict> inventory) {
        // Print out the list of items
        for (Dict item : inventory) {
            System.out.println(item);
        }
    }

    public static void displayOptions() {
        System.out.println(""); // Spacing
        System.out.println("1: Add Item");
        System.out.println("2: Remove Item");
        System.out.println("3: Update Item");
        System.out.println("4: Display Inventory");
        System.out.println("5: Quit");
        System.out.println(""); // Spacing
    }

    public static int getOptionInput() {
        int option = 0;
        Scanner scan = new Scanner(System.in); // Allows for input

        System.out.println("Enter a number correlating to an option.");
        System.out.print("> ");
        option = Integer.parseInt(scan.nextLine());

        scan.close();

        return option;
    }

    public static void selectOption(int option, List<Dict> inventory) {
        if (option == 1) {
            getItemInput(inventory);
            addItem(inventory);
        }
        else if (option == 2) {
            getItemToRemove(inventory);
        }
        else if (option == 3) {
            updateItem();
        }
        else {
            displayInventory(inventory);
        }
    }
    
    public static void getItemInput(List<Dict> inventory) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String name = scan.nextLine();

        System.out.print("Enter item cost: ");
        double price = scan.nextDouble();

        System.out.print("Enter item quantity: ");
        int quantity = scan.nextInt();

        Dict newItem = new Dict(name, price, quantity);
        inventory.add(newItem);

        scan.close();
    }

    public static void addItem(List<Dict> inventory) {
        inventory.add(new Dict("Apple", 1.99, 10));
    }

    public static void getItemToRemove(List<Dict> inventory) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter item name: ");
        String item = scan.nextLine();
        removeItem(item, inventory);

        scan.close();
    }

    public static void removeItem(String item, List<Dict> inventory) {
        try {
            for (int i = 0; i < inventory.size(); i++) {
                if (item.equals(inventory.get(i))) {
                    inventory.remove(i);
                    System.out.println("We have removed " + item + " from the list.");
                    return;
                }
            }
            System.out.println("This isn't in the list.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void updateItem() {
        // Stub.
    }

    public static void main(String[] args) {
        boolean done = false;
        int option = 0;

        // Create a list of Dict objects
        List<Dict> inventory = new ArrayList<>();
        inventory.add(new Dict("Apple", 1.99, 10));
        inventory.add(new Dict("Bread", 2.49, 5));
        inventory.add(new Dict("Milk", 3.29, 8));
        
        while (!done) {
            // End program.
            if (option == 5) {
                done = true;
            }
            // Keep going.
            else {
                displayOptions();
                option = getOptionInput();
                selectOption(option, inventory);
            }
        }
    }
}

