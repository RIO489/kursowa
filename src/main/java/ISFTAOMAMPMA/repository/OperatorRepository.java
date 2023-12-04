package ISFTAOMAMPMA.repository;

import ISFTAOMAMPMA.entity.Operator;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Table
@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {
    Optional<Operator> findByEmail(String email);

    Boolean existsByEmail(String email);
}
