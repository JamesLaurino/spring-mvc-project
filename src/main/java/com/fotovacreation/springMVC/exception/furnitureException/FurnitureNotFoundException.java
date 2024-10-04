package com.fotovacreation.springMVC.exception.furnitureException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 404 (Not Found)
public class FurnitureNotFoundException extends RuntimeException {

    public FurnitureNotFoundException(String message) {
        super(message);
    }
}