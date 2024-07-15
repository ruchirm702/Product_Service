package ruchir.dev.product_service_24.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruchir.dev.product_service_24.models.Product;
import ruchir.dev.product_service_24.services.ProductService;


import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private ProductService productService; // Declares a private member variable for the ProductService


    // Constructor for dependency injection of the ProductService
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Endpoint to get a product by its ID
    // Accessible at http://localhost:8080/products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id ) {
        ResponseEntity<Product> responseEntity = null ;
        try{
            Product product = productService.getSingleProduct(id);
            responseEntity = new ResponseEntity<>(
                    product,
                    HttpStatus.OK
            );
        }
        catch(RuntimeException e){
            responseEntity = new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
        return responseEntity;
    }


    // Endpoint to get all products
    // Accessible at http://localhost:8080/products
    @GetMapping() //No input parameter required
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    public void deleteProduct(Long productId){

    }


    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id ,@RequestBody Product product){
        return productService.updateProduct(id , product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id ,@RequestBody Product product){
        return null;
    }


 }
