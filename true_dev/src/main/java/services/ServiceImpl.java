package services;

import dtos.data.JsonData;
import dtos.postcode.BusiestPostCode;
import dtos.postcode.PostCode;
import dtos.recipes.MatchingRecipes;
import dtos.recipes.RecipeCount;
import dtos.recipes.RecipesCount;
import dtos.recipes.UniqueRecipeCount;
import helpers.Helpers;
import io.github.cdimascio.dotenv.Dotenv;
import utils.JsonUtils;
import utils.RecipeComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceImpl implements IService{
    @Override
    public List<JsonData> functionalRequirementOne(JsonUtils jsonUtils, List<JsonData> data) {
        List<JsonData> uniqueRecipes = data.stream()
                .filter( Helpers.distinctByKey(jsonData -> jsonData.getRecipe()))
                .collect( Collectors.toList() );

        System.out.println(jsonUtils.toJsonString(UniqueRecipeCount.builder()
                .uniqueRecipeCount(uniqueRecipes.size())));
        return uniqueRecipes;
    }

    @Override
    public void functionalRequirementTwo(JsonUtils jsonUtils, List<JsonData> data, List<JsonData> uniqueRecipes) {
        RecipesCount recipesCount = new RecipesCount();
        List<RecipeCount> recipeCountList = new ArrayList<>();
        for (JsonData jsonData: uniqueRecipes) {
            recipeCountList.add(new RecipeCount(jsonData.getRecipe(),
                    Collections.frequency(data.stream().map(item -> item.getRecipe())
                            .collect(Collectors.toList()), jsonData.getRecipe())));
        }
        recipesCount.setRecipeCount(recipeCountList);
        Collections.sort(recipeCountList, new RecipeComparator());
        System.out.println(jsonUtils.toJsonString(recipesCount));
    }

    @Override
    public void functionalRequirementThree(JsonUtils jsonUtils, List<JsonData> data) {
        List<String> postCodes = data.stream().map(item -> item.getPostCode()).collect(Collectors.toList());
        String postCode = Helpers.findMostFrequentItem(postCodes);
        Integer deliveryCount = Collections.frequency(postCodes, postCode);
        System.out.println(jsonUtils.toJsonString(new BusiestPostCode(new PostCode(postCode, deliveryCount))));
    }

    @Override
    public void functionalRequirementFour(JsonUtils jsonUtils, List<JsonData> data) {
        Dotenv dotenv = Dotenv.load();
        List<String> possibleRecipePartialContent = Stream.of(dotenv.get("ALLOWED_RECIPES").split(",", -1))
                .collect(Collectors.toList());
        List<String> recipes = data.stream().map(item -> item.getRecipe())
                .filter(recipe -> Helpers.hasMatchingSubstringOfRecipes(recipe, possibleRecipePartialContent))
                .collect(Collectors.toList());
        Collections.sort(recipes);
        System.out.println(jsonUtils.toJsonString(new MatchingRecipes(recipes)));
    }
}
