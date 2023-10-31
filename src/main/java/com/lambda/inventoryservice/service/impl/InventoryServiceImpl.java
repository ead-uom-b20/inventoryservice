package com.lambda.inventoryservice.service.impl;

import com.lambda.inventoryservice.repository.InventoryRepository;
import com.lambda.inventoryservice.service.InventoryService;
import com.lambda.inventoryservice.utils.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {
    private final ServiceUtil serviceUtil;
    private final InventoryRepository inventoryRepository;

}
