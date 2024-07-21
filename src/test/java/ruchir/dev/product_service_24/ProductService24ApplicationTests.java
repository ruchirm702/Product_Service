package ruchir.dev.product_service_24;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ruchir.dev.product_service_24.models.Category;
import ruchir.dev.product_service_24.models.Product;
import ruchir.dev.product_service_24.projections.ProductWithIdAndTitle;
import ruchir.dev.product_service_24.repositories.Category_Repository;
import ruchir.dev.product_service_24.repositories.Product_Repository;

import java.util.List;
import java.util.Optional;

@SpringBootTest // Marks this class as a Spring Boot test class
class ProductService24ApplicationTests {

    @Autowired
    private Product_Repository product_Repository; // Injects the Product repository

    @Autowired
    private Category_Repository category_repository;  // Injects the Category repository

    @Test
    void contextLoads() { // Test to ensure the application context loads successfully
    }

    @Test
    void testDBQueries() {
//        List<ProductWithIdAndTitle> productWithIdAndTitles =
//                product_Repository.randomSearchMethod();
//
//        for (ProductWithIdAndTitle product : productWithIdAndTitles) {
//            System.out.println(product.getId() + " " + product.getTitle());
//        }

        Optional<Product> product = product_Repository.findById(1L);
        Optional<Category> optionalCategory = category_repository.findById(1L);

//        Category category = optionalCategory.get();
//
//        System.out.println("Getting Product");
//        List<Product> products = category.getProducts();

        System.out.println("DEBUG");
    }

}