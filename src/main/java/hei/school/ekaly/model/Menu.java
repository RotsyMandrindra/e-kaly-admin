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
public class Menu {
    private UUID menuId;
    private String menuName;
    private double unitPrice;
    private UUID restaurantId;
}
