package services;

import dtos.data.JsonData;
import utils.JsonUtils;

import java.util.List;

public interface IService {
    List<JsonData> functionalRequirementOne(JsonUtils jsonUtils, List<JsonData> data);
    void functionalRequirementTwo(JsonUtils jsonUtils, List<JsonData> data, List<JsonData> uniqueRecipes);
    void functionalRequirementThree(JsonUtils jsonUtils, List<JsonData> data);
    void functionalRequirementFour(JsonUtils jsonUtils, List<JsonData> data);
}
