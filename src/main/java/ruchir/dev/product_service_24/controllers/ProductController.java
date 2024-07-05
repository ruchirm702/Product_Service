package ruchir.dev.product_service_24.controllers;

import ruchir.dev.product_service_24.models.Product;
import ruchir.dev.product_service_24.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public Product getProductById(@PathVariable("id") Long id ) {
        return productService.getSingleProduct(id);
    }

    // Endpoint to get all products
    // Accessible at http://localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


 }
