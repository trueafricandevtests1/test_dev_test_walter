package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import dtos.postcode.BusiestPostCode;
import dtos.postcode.PostCode;
import dtos.recipes.MatchingRecipes;
import dtos.recipes.RecipeCount;
import dtos.data.JsonData;
import dtos.recipes.RecipesCount;
import dtos.recipes.UniqueRecipeCount;
import helpers.Helpers;
import services.ServiceImpl;
import utils.JsonUtils;
import utils.RecipeComparator;

import java.util.*;
import java.util.stream.Collectors;

public class Processor {
    public static void main(String[] args) {

        /**
         * Prerequisites: Get the Json Data.
         */
        JsonUtils jsonUtils = new JsonUtils();
        List<JsonData> data =  jsonUtils.jsonToObject();
        ServiceImpl service = new ServiceImpl();

        /**
         * 1. Count the number of unique recipe names
         */
        System.out.println("1.=============================================");
        List<JsonData> uniqueRecipes = service.functionalRequirementOne(jsonUtils, data);

        /**
         * Count the number of occurrences for each unique recipe name (alphabetically ordered by recipe name).
         */
        System.out.println("2.=============================================");
        service.functionalRequirementTwo(jsonUtils, data, uniqueRecipes);

        /**
         * Find the postcode with most delivered recipes.
         */
        System.out.println("3.=============================================");
        service.functionalRequirementThree(jsonUtils, data);

        /**
         * List the recipe names (alphabetically ordered) that contain in their name one of the following words:
         * Potato
         * Veggie
         * Mushroom
         */
        System.out.println("4.=============================================");
        service.functionalRequirementFour(jsonUtils, data);

    }
}
