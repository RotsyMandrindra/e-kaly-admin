package hei.school.ekaly.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Composed {
    private UUID menuId;
    private UUID ingredientId;
    private double quantityRequired;
}
