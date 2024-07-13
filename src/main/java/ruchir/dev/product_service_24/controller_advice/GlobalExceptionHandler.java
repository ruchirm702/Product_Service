package ruchir.dev.product_service_24.controller_advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(){
        ResponseEntity<String> response = new ResponseEntity<>(
                "Something went wrong , coming from Controller Advice",
                HttpStatus.NOT_FOUND
        );
        return response;
    }
}
