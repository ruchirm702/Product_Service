package ruchir.dev.product_service_24.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ruchir.dev.product_service_24.Exceptions.ProductNotFoundException;
import ruchir.dev.product_service_24.models.Category;
import ruchir.dev.product_service_24.models.Product;
import ruchir.dev.product_service_24.repositories.Category_Repository;
import ruchir.dev.product_service_24.repositories.Product_Repository;

import java.util.List;
import java.util.Optional;

@Service("Self_Product_Service")
//@Qualifier("Self_Product_Service")

public class Self_Product_Service implements ProductService{
    private final Category_Repository category_Repository;
    private Product_Repository product_Repository;
    private Category_Repository category_repository;

    public Self_Product_Service(Product_Repository product_Repository, Category_Repository category_Repository) {
        this.product_Repository = product_Repository;
        this.category_Repository = category_Repository;
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

    //PATCH
    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {

        Optional<Product> optionalProduct = product_Repository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist");
        }

        Product productInDB = optionalProduct.get();

        if (product.getTitle() != null) {
            productInDB.setTitle(product.getTitle());
        }

        if (product.getPrice() != null) {
            productInDB.setPrice(product.getPrice());
        }

        return product_Repository.save(productInDB);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException{
        Optional<Product> optionalProduct = product_Repository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist");
        }
        Product existingProduct = optionalProduct.get();

        // Only update the fields that are not null or empty
        if (product.getTitle() != null && !product.getTitle().isEmpty()) {
            existingProduct.setTitle(product.getTitle());
        }
        if (product.getPrice() != null) {
            existingProduct.setPrice(product.getPrice());
        }
        if (product.getCategory() != null) {
            existingProduct.setCategory(product.getCategory());
        }

        return product_Repository.save(existingProduct);
    }


    @Override
    public void deleteProduct(Long id) {
        product_Repository.deleteById(id);
    }

    @Override
    public Product addNewProduct(@RequestBody Product product) {
        Category category = product.getCategory();

        if(category.getId() == null){
            //We need to create a new category object in the DataBase first
            category = category_Repository.save(category);
        }
        return product_Repository.save(product);
    }
}
