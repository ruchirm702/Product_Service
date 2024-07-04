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

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://locathost:8080/products/id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id ) {
        return productService.getSingleProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


 }
