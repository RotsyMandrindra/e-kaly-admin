package hei.school.ekaly.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Action {
    private UUID actionId;
    private String actionType;
    private double stockValue;
    private double sellingValue;
    private double providingValue;
    private Instant actionDate;
}
