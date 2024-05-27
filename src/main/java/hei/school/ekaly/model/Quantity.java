package hei.school.ekaly.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quantity {
    private UUID quantityId;
    private String quantityName;
}
