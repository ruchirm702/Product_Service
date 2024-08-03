package ruchir.dev.product_service_24.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruchir.dev.product_service_24.Exceptions.ProductNotFoundException;
import ruchir.dev.product_service_24.models.Product;
import ruchir.dev.product_service_24.services.ProductService;


import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private ProductService productService; // Declares a private member variable for the ProductService


    // Constructor for dependency injection of the ProductService
    public ProductController(@Qualifier("Self_Product_Service")
            ProductService productService) {
        this.productService = productService;
    }

    // Endpoint to get a product by its ID
    // Accessible at http://localhost:8080/products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id ) throws ProductNotFoundException {

        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );
        return response;
    }


    // Endpoint to get all products
    // Accessible at http://localhost:8080/products
    @GetMapping() //No input parameter required
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
        return productService.getAllProducts(pageNumber, pageSize);
    }


    // Endpoint to delete a product by its ID
    // Accessible at http://localhost:8080/products/{id}
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
    }


    //PATCH
    // Endpoint to partially update a product by its ID
    // Accessible at http://localhost:8080/products/{id}
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id ,@RequestBody Product product)  throws ProductNotFoundException{
        return productService.updateProduct(id , product);
    }

    //PUT
    // Endpoint to fully replace a product by its ID
    // Accessible at http://localhost:8080/products/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        Product updatedProduct = productService.replaceProduct(id, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    //Post
    // Endpoint to add a new product
    // Accessible at http://localhost:8080/products
    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }
 }
