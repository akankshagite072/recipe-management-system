package oop_recipe_management_system;

public class Ingredient extends CookingItem {
    private double quantity;
    private String unit;

    public Ingredient(String name, double quantity, String unit) {
        super(name);
        this.quantity = quantity;
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public void displayDetails() {
        System.out.println(quantity + " " + unit + " of " + name);
    }
}
	