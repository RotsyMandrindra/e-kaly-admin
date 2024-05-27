package hei.school.ekaly.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {
    private UUID ingredientId;
    private String ingredientName;
    private double unitPrice;
    private UUID quantityId;
    private UUID  actionId;
}
