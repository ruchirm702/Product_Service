package ruchir.dev.product_service_24.Controller_Advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Global_Exception_Handler {

    @ExceptionHandler

    public ResponseEntity<String> handleArithmeticException(){
        ResponseEntity<String> response = new ResponseEntity<>(
                "Something went Wrong , Coming from Controller_Advice ",
                HttpStatus.BAD_REQUEST
        );
        return response;
    }

}
