package ruchir_mandora.example.product_service_24.services;

import ruchir_mandora.example.product_service_24.DTOs.FakeStoreProductDTO;
import ruchir_mandora.example.product_service_24.models.Category;
import ruchir_mandora.example.product_service_24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;


    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        //Call FakeStore to fetch the Product with given id ---> via Http Call
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + productId ,
                        FakeStoreProductDTO.class);



        return  convertFakeStoreProductToProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class
        );

        //Convert List of FakeStoreProductDTO into List of product.
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS ){
            products.add(convertFakeStoreProductToProduct(fakeStoreProductDTO));
        }

        return products;
    }
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
