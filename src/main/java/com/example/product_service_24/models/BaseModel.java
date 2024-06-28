package com.example.product_service_24.models;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter

public class BaseModel {
    private long id;
    private Date created_at;
    private Date updated_at;
}
