package ruchir.dev.product_service_24.Inheritance_Types.Table_per_class;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Tpc_Users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )

public class User {
    @Id
    private long id ;
    private String name;
    private String email;
}
