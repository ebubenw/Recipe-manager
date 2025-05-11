/*
 * Student Name: Nwachukwu Ebube 041165175 
 * Professor Name: Amal Ibrahim
 * Course Section: 302
 * Assignment: 3
 * This class allows the user to make an order by prompting the user for selections from menus being displayed to him/her
 */

package assn3;

import java.util.*;

/**
 * This class allows the user to make an order by prompting the user for selections from menus being displayed to him/her
 */
public class RecipeManagerTest {
	
	static RecipeManager manager = new RecipeManager();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            manager.loadRecipesFromFile("recipelist.txt");

            int choice;
            do {
                displayMenu();  
                choice = scanner.nextInt();

                if (choice == 1) {
                    displayRecipes();  
                } else if (choice == 2) {
                    orderBread();  
                } else if (choice == 3) {
                    printShoppingList();  
                }
            } while (choice != 0);  
        }
        catch (Exception j) {
            System.out.println("Error: " + j.getMessage()); 
        }
    }

    /**
     * Displays menu of options for the user to choose from.
     */
    private static void displayMenu() {
        System.out.printf("%nRecipe Manager%n");
        System.out.println("1. Display Recipes");
        System.out.println("2. Order Bread");
        System.out.println("3. Generate Shopping List");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Displays the list of available recipes.
     */
    private static void displayRecipes() {
        List<Recipe> recipes = manager.getRecipes();
        System.out.println("Available Bread Recipes:");
        for (int i = 0; i < recipes.size(); i++) {
            System.out.println((i + 1) + ". " + recipes.get(i).getName());
        }
    }

    /**
     * Prompts the user to enter his option of bread from the menu and also specify the quantity
     */
    private static void orderBread() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number for the bread you want to order: ");
            int breadNumber = scanner.nextInt();
            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();

            // Validate the chosen recipe number and quantity
            if (breadNumber < 1 || breadNumber > manager.getRecipes().size()) {
                System.out.println("Invalid recipe number.");
            } else {
                Recipe recipe = manager.getRecipes().get(breadNumber - 1);
                if (quantity < 0) {
                    System.out.println("Quantity must be a positive number.");
                } else {
                    recipe.addQuantityOrdered(quantity);  // Update quantity ordered
                    System.out.println("Ordered " + quantity + " " + recipe.getName() + "(s).");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input: " + e.getMessage());
            scanner.nextLine(); 
        }
    }

    /**
     * Prompts the user to decide whether they want to save the shopping list to a file.
     */
    private static void printShoppingList() { 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to save the shopping list? (y/n): ");
        String saveResponse = scanner.next();

        if (saveResponse.equalsIgnoreCase("y")) {
            manager.saveShoppingList("shoppinglist.txt");  
            System.out.println("Shopping list saved.");
        } else {
            System.out.println("Shopping list not saved.");
        }
    }
}
