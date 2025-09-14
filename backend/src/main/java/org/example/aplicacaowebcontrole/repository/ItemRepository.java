package org.example.aplicacaowebcontrole.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.mail.FetchProfile.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByUsername(String username);
    boolean existsByUsername(String username);
}