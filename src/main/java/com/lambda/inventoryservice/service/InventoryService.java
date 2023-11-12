package com.lambda.inventoryservice.service;

import com.lambda.inventoryservice.domain.InventoryDomain;
import com.lambda.inventoryservice.dto.ResponseDto;
import org.springframework.stereotype.Service;


public interface InventoryService{
    ResponseDto findAllItems();
    ResponseDto findItemById(Long id);
    Long findItemByIdQua(Long id);
    ResponseDto addItem(InventoryDomain inventoryDomain);
    ResponseDto updateItem(InventoryDomain inventoryDomain, Long id);
    ResponseDto deleteItem(Long id);
}
