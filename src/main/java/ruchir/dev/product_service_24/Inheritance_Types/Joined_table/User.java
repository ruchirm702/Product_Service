package ruchir.dev.product_service_24.Inheritance_Types.Joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Joined_Users")
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
    @Id
    private long id ;
    private String name;
    private String email;
}
