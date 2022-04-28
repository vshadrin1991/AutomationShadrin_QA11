package Lecture_17;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bin {
    String position_id;
    String product_id;
    String product_key;
    String shop_id;
    Integer quantity;
}
