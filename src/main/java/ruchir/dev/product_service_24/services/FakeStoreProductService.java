package ruchir.dev.product_service_24.services;

import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import ruchir.dev.product_service_24.DTOs.FakeStoreProductDTO;
import ruchir.dev.product_service_24.Exceptions.ProductNotFoundException;
import ruchir.dev.product_service_24.models.Category;
import ruchir.dev.product_service_24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

// Marks this class as a service component in Spring
@Service("Fakestore_Product_Service")
//@Primary

//@Qualifier("fakeStoreProductService")

public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate; // RestTemplate for HTTP calls
    private RedisTemplate<String, Object> redisTemplate;

    // Constructor for dependency injection
    public FakeStoreProductService(RestTemplate restTemplate,
                                   RedisTemplate redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }


    // Fetch a single product by ID
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException{

        //Try to fetch the product from redis.
        Product product = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCT_" + productId);

        if (product != null) {
            //Cache HIT
            return product;
        }

        //Call FakeStore to fetch the Product with given id ---> via Http Call
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + productId ,
                        FakeStoreProductDTO.class);

        if (fakeStoreProductDTO == null) {
            throw new ProductNotFoundException("Product with id " + productId + " doesn't exist");
        }

        // Convert DTO to Product and return
        //return  convertFakeStoreProductToProduct(fakeStoreProductDTO);

        //Convert FakeStoreProductDto into Product.
        //Cache MISS
        product = convertFakeStoreProductToProduct(fakeStoreProductDTO);


        //Store the product in redis.
        redisTemplate.opsForHash().put("PRODUCTS", "PRODUCT_" + productId, product);

        return product;
    }



    // Fetch all products
    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {

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

        return  new PageImpl<>(products);
    }


    //Partial Update :  Update a product partially
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

    @Override
    public Product addNewProduct(Product product) {
        return null;
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
