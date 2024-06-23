package oop_recipe_management_system;

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CookingItem> cookingItems = new ArrayList<>();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Upload a new recipe");
            System.out.println("2. Look at existing recipes");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the recipe name: ");
                    String recipeName = scanner.nextLine();
                    System.out.print("Enter the recipe description: ");
                    String recipeDescription = scanner.nextLine();
                    Recipe newRecipe = new Recipe(recipeName, recipeDescription);

                    System.out.print("Enter the number of ingredients: ");
                    int numIngredients = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    for (int i = 0; i < numIngredients; i++) {
                        System.out.print("Enter ingredient name: ");
                        String ingredientName = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        double ingredientQuantity = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter unit: ");
                        String ingredientUnit = scanner.nextLine();
                        Ingredient ingredient = new Ingredient(ingredientName, ingredientQuantity, ingredientUnit);
                        newRecipe.addIngredient(ingredient);
                    }

                    cookingItems.add(newRecipe);
                    System.out.println("Recipe added successfully!");
                    break;

                case 2:
                    if (cookingItems.isEmpty()) {
                        System.out.println("No recipes available. Please upload a new recipe.");
                    } else {
                        System.out.println("Existing recipes:");
                        for (int i = 0; i < cookingItems.size(); i++) {
                            CookingItem item = cookingItems.get(i);
                            System.out.println((i + 1) + ". " + item.getName());
                        }
                        System.out.print("Enter the recipe number you want to view: ");
                        int recipeNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (recipeNumber >= 1 && recipeNumber <= cookingItems.size()) {
                            CookingItem selectedItem = cookingItems.get(recipeNumber - 1);
                            if (selectedItem instanceof Recipe) {
                                Recipe selectedRecipe = (Recipe) selectedItem;
                                selectedRecipe.displayDetails();
                            }
                        } else {
                            System.out.println("Invalid recipe number.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}

