package ruchir.dev.product_service_24.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ruchir.dev.product_service_24.Exceptions.ProductNotFoundException;
import ruchir.dev.product_service_24.models.Product;
import ruchir.dev.product_service_24.repositories.Product_Repository;

import java.util.List;
@Service("Self_Product_Service")
//@Qualifier("Self_Product_Service")

public class Self_Product_Service implements ProductService{
    private Product_Repository product_repository;

    public Self_Product_Service(Product_Repository product_repository) {
        this.product_repository = product_repository;
     }


    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // Make a call to Database to fetch a product with Given Id

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }
}
