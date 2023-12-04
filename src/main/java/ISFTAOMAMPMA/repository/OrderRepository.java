package ISFTAOMAMPMA.repository;

import ISFTAOMAMPMA.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
@Table
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value = "SELECT o FROM Order o WHERE o.customer.id= :customer_id")
    List<Order> findAllByCustomerId(Long customer_id);
}
