package oop_recipe_management_system;

public abstract class CookingItem {
    protected String name;

    public CookingItem(String name) {
        this.name = name;
    }

    public abstract void displayDetails();

    public String getName() {
        return name;
    }
}
