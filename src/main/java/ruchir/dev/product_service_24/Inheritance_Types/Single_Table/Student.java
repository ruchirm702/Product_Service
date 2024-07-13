package ruchir.dev.product_service_24.Inheritance_Types.Single_Table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1")

public class Student extends User {
    private String batch ;
}
