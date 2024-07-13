package ruchir.dev.product_service_24.Inheritance_Types.Joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Joined_Students")
@PrimaryKeyJoinColumn(name = "user_id")

public class Student extends User{
    private String batch ;
}
