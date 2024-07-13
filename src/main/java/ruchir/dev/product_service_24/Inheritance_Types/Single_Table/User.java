package ruchir.dev.product_service_24.Inheritance_Types.Single_Table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Single_Users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(
        name = "User_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")

public class User {
    @Id
    private long id ;
    private String name;
    private String email;
}
