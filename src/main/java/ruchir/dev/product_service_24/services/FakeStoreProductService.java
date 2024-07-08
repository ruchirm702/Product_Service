package ruchir.dev.product_service_24.services;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
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
        // Using an array of FakeStoreProductDTO because of type erasure
        // Type erasure removes generic type information at runtime, making it difficult to handle generics
        // Arrays retain their type information at runtime, allowing RestTemplate to correctly infer the type



        // Convert the array of FakeStoreProductDTO into a list of Product
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS ){
            products.add(convertFakeStoreProductToProduct(fakeStoreProductDTO));
        }

        return products;
    }


    //Partial Update
    @Override
    public Product updateProduct(Long id, Product product) {
        //PATCH call
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product ,FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDTO.class, restTemplate.getMessageConverters());

        FakeStoreProductDTO response =restTemplate.execute("https://fakestoreapi.com/products/" + id ,
                HttpMethod.PATCH, requestCallback, responseExtractor);

        return  convertFakeStoreProductToProduct(response);

    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        //PUT Call
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

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
