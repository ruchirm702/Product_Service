package ruchir.dev.product_service_24.Controller_Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ruchir.dev.product_service_24.DTOs.ExceptionDTO;
import ruchir.dev.product_service_24.Exceptions.ProductNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class Global_Exception_Handler {

    @ExceptionHandler(ArithmeticException.class) // Handle arithmetic exceptions
    public ResponseEntity<ExceptionDTO> handleArithmeticException(ArithmeticException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setTimestamp(LocalDateTime.now());
        exceptionDTO.setError("Arithmetic Error");
        exceptionDTO.setMessage("An arithmetic error has occurred: " + ex.getMessage());
        exceptionDTO.setSolution("Check your calculations and try again.");
        exceptionDTO.setStatus(HttpStatus.BAD_REQUEST.value());

        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(
                exceptionDTO,
                HttpStatus.BAD_REQUEST
        );

        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class) // Handle array index out of bounds exceptions
    public ResponseEntity<ExceptionDTO> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setTimestamp(LocalDateTime.now());
        exceptionDTO.setError("Array Index Out Of Bounds");
        exceptionDTO.setMessage("Array index out of bounds error has occurred: " + ex.getMessage());
        exceptionDTO.setSolution("Ensure your index is within the valid range.");
        exceptionDTO.setStatus(HttpStatus.BAD_REQUEST.value());

        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(
                exceptionDTO,
                HttpStatus.BAD_REQUEST
        );

        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class) // Handle product not found exceptions
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setTimestamp(LocalDateTime.now());
        exceptionDTO.setError("Product Not Found");
        exceptionDTO.setMessage("The product you are looking for was not found: " + ex.getMessage());
        exceptionDTO.setSolution("Please try again with a valid product id.");
        exceptionDTO.setStatus(HttpStatus.NOT_FOUND.value());

        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(
                exceptionDTO,
                HttpStatus.BAD_REQUEST
        );

        return response;
    }
}
