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
@MappedSuperclass // Indicates that this class is a base class for entities

public class BaseModel {
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // // Auto-increment  for the primary key
    private Long id;
    private Date created_at;
    private Date updated_at;
}
