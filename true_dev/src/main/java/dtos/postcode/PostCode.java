package dtos.postcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostCode {
    @JsonProperty("postcode")
    private String postCode;
    @JsonProperty("delivery_count")
    private Integer deliveryCount;
}
