package ISFTAOMAMPMA.repository;

import ISFTAOMAMPMA.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Optional;
@Table
@Repository
public interface AdminRepository extends JpaRepository<Administrator, Long> {
    Optional<Administrator> findByEmail(String email);

    Boolean existsByEmail(String email);
}
