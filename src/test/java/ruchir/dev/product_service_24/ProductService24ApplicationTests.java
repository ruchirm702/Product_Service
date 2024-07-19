package ruchir.dev.product_service_24;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ruchir.dev.product_service_24.projections.ProductWithIdAndTitle;
import ruchir.dev.product_service_24.repositories.Product_Repository;

import java.util.List;

@SpringBootTest
class ProductService24ApplicationTests {

    @Autowired
    private Product_Repository product_Repository;

    @Test
    void contextLoads() {
    }

    @Test
    void testDBQueries() {
        List<ProductWithIdAndTitle> productWithIdAndTitles =
                product_Repository.randomSearchMethod();

        for (ProductWithIdAndTitle product : productWithIdAndTitles) {
            System.out.println(product.getId() + " " + product.getTitle());
        }

        System.out.println("DEBUG");
    }

}