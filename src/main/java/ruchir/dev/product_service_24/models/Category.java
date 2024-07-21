package ruchir.dev.product_service_24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity // Marks this class as a JPA entity

 public class Category extends BaseModel{
    private String name;
    private String description;

    // List of products associated with this category
    @OneToMany(mappedBy = "category" , fetch = FetchType.EAGER) // one-to-many relationship with the Product entity
    private List<Product> products;


}
