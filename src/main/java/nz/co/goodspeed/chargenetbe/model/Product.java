package nz.co.goodspeed.chargenetbe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    Integer id;
    String description;
    String name;
    Double price;
    Boolean disabled;
}
