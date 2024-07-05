package ruchir.dev.product_service_24.services;

import ruchir.dev.product_service_24.DTOs.FakeStoreProductDTO;
import ruchir.dev.product_service_24.models.Category;
import ruchir.dev.product_service_24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service // Marks this class as a service component in Spring
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate; // Declares a private RestTemplate member for making HTTP calls

    // Constructor for dependency injection of RestTemplate
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    // Implementation of the getSingleProduct method from the ProductService interface
    @Override
    public Product getSingleProduct(Long productId) {
        //Call FakeStore to fetch the Product with given id ---> via Http Call
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + productId ,
                        FakeStoreProductDTO.class);

        // Convert the received FakeStoreProductDTO to a Product and return it
        return  convertFakeStoreProductToProduct(fakeStoreProductDTO);
    }



    // Implementation of the getAllProducts method from the ProductService interface
    @Override
    public List<Product> getAllProducts() {
        // Call FakeStore API to fetch all products via HTTP call
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class
        );

        // Convert the array of FakeStoreProductDTO into a list of Product
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS ){
            products.add(convertFakeStoreProductToProduct(fakeStoreProductDTO));
        }

        return products;
    }



    // Helper method to convert FakeStoreProductDTO into Product
    private Product convertFakeStoreProductToProduct(FakeStoreProductDTO fakeStoreProductDTO){
        //Convert FakeStoreProductDTO into Product.
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product ;
    }

}
