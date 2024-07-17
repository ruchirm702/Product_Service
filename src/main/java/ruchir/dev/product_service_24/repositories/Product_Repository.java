package ruchir.dev.product_service_24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruchir.dev.product_service_24.models.Product;

import java.util.List;

@Repository
public interface Product_Repository extends JpaRepository<Product, Long> {
    //Product Repo should contain all the methods related to Product Model

    List<Product> findByPriceIsGreaterThan(Double price);

    List<Product> findProductByTitleLike(String word); // Case sensitive
    //select * from products where title like '%iphone%'

    List<Product> findByTitleLikeIgnoreCase(String word); // wil make case insensitive.



}


