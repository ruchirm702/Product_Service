package ruchir.dev.product_service_24.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass

public class BaseModel {
    @Id // for Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AUTO-INCREMENT
    private long id;
    private Date created_at;
    private Date updated_at;
}
