package nz.co.goodspeed.chargenetbe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @CreationTimestamp
    Timestamp dateCreated;

    String customer;

    @OneToMany(cascade=CascadeType.PERSIST,mappedBy = "id", targetEntity = OrderLines.class)
    Set<OrderLines> orderLines;

}
