package utils;

import dtos.recipes.RecipeCount;

import java.util.Comparator;

public class RecipeComparator implements Comparator<RecipeCount> {
    @Override
    public int compare(RecipeCount o1, RecipeCount o2) {
        return o1.getRecipe().compareTo(o2.getRecipe());
    }
}
