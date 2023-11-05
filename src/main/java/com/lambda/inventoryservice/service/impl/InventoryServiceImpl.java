package com.lambda.inventoryservice.service.impl;

import com.lambda.inventoryservice.domain.InventoryDomain;
import com.lambda.inventoryservice.dto.ResponseDto;
import com.lambda.inventoryservice.repository.InventoryRepository;
import com.lambda.inventoryservice.service.InventoryService;
import com.lambda.inventoryservice.utils.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {
    private final ServiceUtil serviceUtil;
    private final InventoryRepository inventoryRepository;

    @Override
    public ResponseDto findAllItems() {
        ResponseDto responseDto;
        try{
            List<InventoryDomain> items = inventoryRepository.findAll();
            responseDto =  serviceUtil.getServiceResponse(items);
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Can not get items");
        }
        return responseDto;
    }

    @Override
    public ResponseDto findItemById(Long id) {
        ResponseDto responseDto;
        try{
            Optional<InventoryDomain> items = inventoryRepository.findById(id);
            InventoryDomain inventoryDomain = null;
            if(items.isPresent()){
                inventoryDomain = items.get();
            }
            responseDto =  serviceUtil.getServiceResponse(inventoryDomain);
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Can not get item");
        }
        return responseDto;
    }

    @Override
    public ResponseDto addItem(InventoryDomain inventoryDomain) {
        ResponseDto responseDto = null;
        try{
            InventoryDomain savedOrder = inventoryRepository.save(inventoryDomain);
            responseDto =  serviceUtil.getServiceResponse(savedOrder);
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Can not create new item");
        }
        return responseDto;
    }

    @Override
    public ResponseDto updateItem(InventoryDomain inventoryDomain, Long id) {
        ResponseDto responseDto = null;
        try{
            Optional<InventoryDomain> optionalInventory = inventoryRepository.findById(id);
            if(optionalInventory.isPresent()){
                InventoryDomain queriedInventory = optionalInventory.get();
                queriedInventory.setProductName(inventoryDomain.getProductName());
                queriedInventory.setQuantity(inventoryDomain.getQuantity());
                queriedInventory.setStatus(inventoryDomain.getStatus());
                queriedInventory.setUnitPrice(inventoryDomain.getUnitPrice());
                InventoryDomain savedData = inventoryRepository.save(queriedInventory);
                responseDto = serviceUtil.getServiceResponse(savedData);
            }else{
                responseDto = serviceUtil.getServiceResponse("No item found in this ID");
            }
        } catch (Exception e){
            responseDto = serviceUtil.getErrorServiceResponse("Can not update the item");
        }
        return responseDto;
    }

    @Override
    public ResponseDto deleteItem(Long id) {
        ResponseDto responseDto = null;
        try{
            Optional<InventoryDomain> optionalInventory = inventoryRepository.findById(id);
            if(optionalInventory.isPresent()){
                InventoryDomain queriedInventory = optionalInventory.get();
                inventoryRepository.deleteById(queriedInventory.getId());
                responseDto = serviceUtil.getServiceResponse("Successfully deleted");
            }
        } catch (Exception e){
            responseDto = serviceUtil.getErrorServiceResponse("Can not update the item");
        }
        return responseDto;
    }
}
