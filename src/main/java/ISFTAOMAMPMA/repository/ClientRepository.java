package ISFTAOMAMPMA.repository;


import ISFTAOMAMPMA.entity.Client;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Optional;
@Table
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);

    Boolean existsByEmail(String email);
}
