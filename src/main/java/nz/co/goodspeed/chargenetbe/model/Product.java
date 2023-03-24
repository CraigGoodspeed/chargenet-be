package nz.co.goodspeed.chargenetbe.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String description;
    String name;
    Double price;
    Boolean enabled = true;

    @CreationTimestamp
    Timestamp dateCreated;

    @UpdateTimestamp
    Timestamp lastUpdated;

    String createdBy;


}
