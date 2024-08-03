package ruchir.dev.product_service_24.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ruchir.dev.product_service_24.Exceptions.ProductNotFoundException;
import ruchir.dev.product_service_24.models.Category;
import ruchir.dev.product_service_24.models.Product;
import ruchir.dev.product_service_24.repositories.Category_Repository;
import ruchir.dev.product_service_24.repositories.Product_Repository;


import java.util.Optional;

@Service("Self_Product_Service") // Marks this class as a Spring service
//@Qualifier("Self_Product_Service")

public class Self_Product_Service implements ProductService{
    private final Category_Repository category_Repository;

    private Product_Repository product_Repository;      // Repository for Product entity
    private Category_Repository category_repository;    // Repository for Category entity

    // Constructor for dependency injection
    public Self_Product_Service(Product_Repository product_Repository, Category_Repository category_Repository) {
        this.product_Repository = product_Repository;
        this.category_Repository = category_Repository;
    }

    // Fetch a single product by ID
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // Make a call to Database to fetch a product with Given Id

        Optional<Product> productOptional = product_Repository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id : " + productId + "doesn't exist");
        }

        return productOptional.get();
    }

    // Fetch all products
    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        Sort sort = Sort.by("price").descending().and(Sort.by("title").ascending());
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return product_Repository.findAll(pageable);
    }




    //PATCH  : Partially update a product by ID
    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {

        Optional<Product> optionalProduct = product_Repository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist");
        }

        Product productInDB = optionalProduct.get();

        // Update fields only if they are not null
        if (product.getTitle() != null) {
            productInDB.setTitle(product.getTitle());
        }

        if (product.getPrice() != null) {
            productInDB.setPrice(product.getPrice());
        }

        return product_Repository.save(productInDB);
    }

    // Replace a product by ID
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

    // Delete a product by ID
    @Override
    public void deleteProduct(Long id) {
        product_Repository.deleteById(id);
    }

    // Add a new product
    @Override
    public Product addNewProduct(@RequestBody Product product) {
        Category category = product.getCategory();


        if(category.getId() == null){
            //We need to create a new category object in the DataBase first
            // Save new category if ID is not present
            category = category_Repository.save(category);
        }
        return product_Repository.save(product);
    }
}