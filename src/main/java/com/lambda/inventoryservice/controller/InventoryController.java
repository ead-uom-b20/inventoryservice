package com.lambda.inventoryservice.controller;

import com.lambda.inventoryservice.domain.InventoryDomain;
import com.lambda.inventoryservice.dto.ResponseDto;
import com.lambda.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/inventories")
    public ResponseDto findAllItems(){
        return inventoryService.findAllItems();
    }

    @GetMapping("/inventory/{id}")
    public ResponseDto findItemById(@PathVariable Long id){
        return inventoryService.findItemById(id);
    }

    @GetMapping("/inventory/quantity/{id}")
    public Long findItemByIdQua(@PathVariable Long id){
        return inventoryService.findItemByIdQua(id);
    }

    @PostMapping("/inventory")
    public ResponseDto addItem(@RequestBody InventoryDomain inventoryDomain){
        return inventoryService.addItem(inventoryDomain);
    }

    @PutMapping("/inventory/{id}")
    public ResponseDto updateItem(@RequestBody InventoryDomain inventoryDomain, @PathVariable Long id){
        return inventoryService.updateItem(inventoryDomain, id);
    }

    @DeleteMapping("/inventory/{id}")
    public ResponseDto deleteItem(@PathVariable  Long id){
        return inventoryService.deleteItem(id);
    }
}
