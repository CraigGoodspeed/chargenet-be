package nz.co.goodspeed.chargenetbe.repo;

import nz.co.goodspeed.chargenetbe.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByOrderByDescriptionDesc();
    List<Product> findAllByDescriptionContaining(String val);


}
