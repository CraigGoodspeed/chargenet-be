package nz.co.goodspeed.chargenetbe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderLines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer productId;

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Order.class)
    Order order;

    Double price;

    Integer quantity;
}
