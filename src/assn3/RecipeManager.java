/*
 * Student Name: Nwachukwu Ebube 041165175 
 * Professor Name: Amal Ibrahim
 * Course Section: 302
 * Assignment: 3
 * This class reads the data from the recipelist.txt file
 * And writes into the shoppinglist.txt file according to the user's selections
 */

package assn3;

import java.io.*;
import java.util.*;

/**
 * This class reads the data from the recipelist.txt file
 * And writes into the shoppinglist.txt file according to the user's selections
 */
public class RecipeManager {
    
    private ArrayList<Recipe> recipes = new ArrayList<>();

    /**
     * Loads recipes from a file. Each recipe in the file must start with "Recipe" followed by its name.
     * The ingredients (sugar, eggs, flour, yeast, butter) for each recipe are also loaded from the file.
     * @param fileName The name of the file containing the recipe data.
     */
    public void loadRecipesFromFile(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            Recipe currentRecipe = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Recipe")) {
                    if (currentRecipe != null) {
                        recipes.add(currentRecipe); 
                    }
                    String recipeName = line.substring(7); 
                    currentRecipe = new Recipe(recipeName, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
                } else if (line.contains("sugar")) {
                    currentRecipe.setSugar(Float.parseFloat(line.split(" ")[1]));  
                } else if (line.contains("eggs")) {
                    currentRecipe.setEggs(Float.parseFloat(line.split(" ")[1]));  
                } else if (line.contains("flour")) {
                    currentRecipe.setFlour(Float.parseFloat(line.split(" ")[1]));  
                } else if (line.contains("yeast")) {
                    currentRecipe.setYeast(Float.parseFloat(line.split(" ")[1]));  
                } else if (line.contains("butter")) {
                    currentRecipe.setButter(Float.parseFloat(line.split(" ")[1])); 
                }
            }

            if (currentRecipe != null) {
                recipes.add(currentRecipe); 
            }
        } catch (IOException e) {
            System.out.println("Error reading the recipe file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numbers in the recipe file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close(); 
                }
            } catch (IOException e) {
                System.out.println("Error closing the file reader: " + e.getMessage());
            }
        }
    }

    /**
     * Saves the shopping list to a file. The shopping list includes all ingredients needed 
     * for the ordered quantity of each recipe.
     * @param fileName The name of the file where the shopping list will be saved.
     */
    public void saveShoppingList(String fileName) {
        BufferedWriter writer = null;
        try {
        	writer = new BufferedWriter(new FileWriter(fileName));
            
            // Iterate through the list of recipes
            for (Recipe recipe : recipes) {
                if (recipe.getQuantityOrdered() > 0) { 
                    writer.write(recipe.getName() + " (" + recipe.getQuantityOrdered() + " ordered)\n");
                    writer.write("sugar: " + recipe.getSugar() * recipe.getQuantityOrdered() + "\n");
                    writer.write("eggs: " + recipe.getEggs() * recipe.getQuantityOrdered() + "\n");
                    writer.write("flour: " + recipe.getFlour() * recipe.getQuantityOrdered() + "\n");
                    writer.write("yeast: " + recipe.getYeast() * recipe.getQuantityOrdered() + "\n");
                    writer.write("butter: " + recipe.getButter() * recipe.getQuantityOrdered() + "\n");
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving the shopping list: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file writer: " + e.getMessage());
            }
        }
    }

    /**
     * Returns the list of available recipes.
     * @return A list all available recipes.
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
