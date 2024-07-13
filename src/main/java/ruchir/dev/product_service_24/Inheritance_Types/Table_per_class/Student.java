package ruchir.dev.product_service_24.Inheritance_Types.Table_per_class;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Tpc_Students")

public class Student extends User {
    private String batch ;
}
