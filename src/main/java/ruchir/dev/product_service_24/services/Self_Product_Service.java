package ruchir.dev.product_service_24.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ruchir.dev.product_service_24.Exceptions.ProductNotFoundException;
import ruchir.dev.product_service_24.models.Product;
import ruchir.dev.product_service_24.repositories.Product_Repository;

import java.util.List;
import java.util.Optional;

@Service("Self_Product_Service")
//@Qualifier("Self_Product_Service")

public class Self_Product_Service implements ProductService{
    private Product_Repository product_Repository;

    public Self_Product_Service(Product_Repository product_Repository) {
        this.product_Repository = product_Repository;
    }


    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // Make a call to Database to fetch a product with Given Id

        Optional<Product> productOptional = product_Repository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id : " + productId + "doesn't exist");
        }

        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return product_Repository.findAll();
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
        product_Repository.deleteById(id);
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }
}
