package com.example.metrics.repository;

import com.example.metrics.entity.clientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<clientEntity, Long> {
}
