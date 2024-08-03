package ruchir.dev.product_service_24.services;

import org.springframework.data.domain.Page;
import ruchir.dev.product_service_24.Exceptions.ProductNotFoundException;
import ruchir.dev.product_service_24.models.Product;
import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product updateProduct(Long id, Product product) throws ProductNotFoundException;

    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;

    void deleteProduct(Long id);

    Product addNewProduct(Product product);


}