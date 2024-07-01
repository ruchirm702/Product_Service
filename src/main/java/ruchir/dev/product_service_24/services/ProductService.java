package ruchir.dev.product_service_24.services;

import ruchir.dev.product_service_24.models.Product;
import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);

    List<Product> getAllProducts();
}
