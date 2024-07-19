package ruchir.dev.product_service_24.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
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
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }




    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
    }


    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id ,@RequestBody Product product){
        return productService.updateProduct(id , product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id ,@RequestBody Product product){
        return null;
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }
 }
