package com.lambda.inventoryservice.utils;

import com.lambda.inventoryservice.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceUtil {
    public ResponseDto getServiceResponse(Object responseObject) {
        return ResponseDto.builder()
                .status(Boolean.TRUE)
                .response(responseObject)
                .build();
    }
    public ResponseDto getErrorServiceResponse(String error) {
        return ResponseDto.builder()
                .status(Boolean.FALSE)
                .error(error)
                .build();
    }
}