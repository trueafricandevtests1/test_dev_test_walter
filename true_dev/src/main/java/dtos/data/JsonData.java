package dtos.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JsonData {
    @JsonProperty("postcode")
    private String postCode;
    private String recipe;
    private String delivery;
}
