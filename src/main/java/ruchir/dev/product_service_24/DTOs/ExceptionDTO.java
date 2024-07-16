package ruchir.dev.product_service_24.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionDTO {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String solution;
}
