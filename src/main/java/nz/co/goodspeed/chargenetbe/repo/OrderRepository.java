package nz.co.goodspeed.chargenetbe.repo;

import jakarta.transaction.Transactional;
import nz.co.goodspeed.chargenetbe.model.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order, Integer> {
}
