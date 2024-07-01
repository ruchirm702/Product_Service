package ruchir_mandora.example.product_service_24.services;

import ruchir_mandora.example.product_service_24.models.Product;
import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);

    List<Product> getAllProducts();
}
