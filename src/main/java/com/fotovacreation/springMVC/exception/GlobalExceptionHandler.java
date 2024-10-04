package com.fotovacreation.springMVC.exception;

import com.fotovacreation.springMVC.exception.furnitureException.FurnitureNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FurnitureNotFoundException.class)
    public String handleProductNotFoundException(FurnitureNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error/furnitureNotFound";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "An unexpected error occurred: " + ex.getMessage());
        return "error/noSuchElementException";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "An unexpected error occurred: " + ex.getMessage());
        return "error/genericError";
    }
}