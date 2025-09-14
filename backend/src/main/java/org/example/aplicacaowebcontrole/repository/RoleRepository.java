package org.example.aplicacaowebcontrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.aplicacaowebcontrole.model.Role; // Add this import for Role entity
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByUsername(String username);
    boolean existsByUsername(String username);
}