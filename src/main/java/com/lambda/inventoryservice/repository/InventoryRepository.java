package com.lambda.inventoryservice.repository;

import com.lambda.inventoryservice.domain.InventoryDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryDomain, Long> {
}
