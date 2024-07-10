package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Service.IngredientService;
import Service.RecipeService;
import entity.Ingredient;


@Controller
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public String getAllIngredients(Model model) {
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "ingredient-list";
    }

    @GetMapping("/{id}")
    public String getIngredientById(@PathVariable Long id, Model model) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        if (ingredient != null) {
            model.addAttribute("ingredient", ingredient);
            return "ingredient-detail";
        } else {
            return "404";
        }
    }

    @GetMapping("/new")
    public String newIngredientForm(Model model) {
        model.addAttribute("ingredient", new Ingredient(null, null, null));
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "ingredient-form";
    }

    @PostMapping
    public String saveIngredient(@ModelAttribute Ingredient ingredient) {
        ingredientService.saveIngredient(ingredient);
        return "redirect:/ingredients";
    }

    @GetMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return "redirect:/ingredients";
    }
}
