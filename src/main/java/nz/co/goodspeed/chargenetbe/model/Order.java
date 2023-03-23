package nz.co.goodspeed.chargenetbe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.List;

@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    DateTime dateCreated;

    String customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id", table = "order_lines",referencedColumnName = "order_id", nullable = false)
    List<OrderLines> orderLines;

}
