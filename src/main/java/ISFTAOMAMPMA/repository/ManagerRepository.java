package ISFTAOMAMPMA.repository;

import org.springframework.data.relational.core.mapping.Table;
import ISFTAOMAMPMA.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Table
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findByEmail(String email);

    Boolean existsByEmail(String email);
}
