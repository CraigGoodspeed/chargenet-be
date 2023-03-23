package nz.co.goodspeed.chargenetbe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import software.amazon.ion.Decimal;

@Entity
@Getter
@Setter
public class OrderLines {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @OneToOne
    @JoinColumn(name = "order_id")
    Order order;

    @OneToOne
    @JoinColumn(name = "product_id")
    Product product;

    Double price;

    Integer quantity;
}
