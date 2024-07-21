package ruchir.dev.product_service_24.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // Marks this class as a JPA entity


public class Product extends BaseModel {
    private String title;
    private Double price ;

    // Many-to-one relationship with the Category entity
    @ManyToOne(cascade = CascadeType.PERSIST )  // Cascade type for persisting operations
    private Category category;  // Category class
}
