package ruchir.dev.product_service_24.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionDTO {
    private LocalDateTime timestamp;    // Timestamp of when the exception occurred
    private int status;                // HTTP status code of the response
    private String error;             // Error type
    private String message;
    private String solution;
}
