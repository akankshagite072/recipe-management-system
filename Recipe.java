package oop_recipe_management_system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Recipe extends CookingItem {
    private String description;
    private ArrayList<Ingredient> ingredients;

    public Recipe(String name, String description) {
        super(name);
        this.description = description;
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public void displayDetails() {
        System.out.println("Recipe: " + name);
        System.out.println("Description: " + description);
        System.out.println("Ingredients:");
        for (Ingredient ingredient : ingredients) {
            System.out.print("- ");
            ingredient.displayDetails();
        }
    }

    public void saveRecipeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(name + ".txt"))) {
            writer.write("Recipe: " + name);
            writer.newLine();
            writer.write("Description: " + description);
            writer.newLine();
            writer.write("Ingredients:");
            writer.newLine();
            for (Ingredient ingredient : ingredients) {
                writer.write(ingredient.getName() + ": " + ingredient.getQuantity() + " " + ingredient.getUnit());
                writer.newLine();
            }
            System.out.println(name + " recipe has been saved to " + name + ".txt");
        } catch (IOException e) {
            System.err.println("Error saving the recipe to a file: " + e.getMessage());
        }
    }
}
