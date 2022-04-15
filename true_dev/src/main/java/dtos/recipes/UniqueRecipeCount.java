package dtos.recipes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UniqueRecipeCount {
    @JsonProperty("unique_recipe_count")
    private Integer uniqueRecipeCount;
}
