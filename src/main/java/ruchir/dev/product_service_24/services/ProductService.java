package ruchir.dev.product_service_24.services;

import ruchir.dev.product_service_24.models.Product;
import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);

    void deleteProduct(Long id);