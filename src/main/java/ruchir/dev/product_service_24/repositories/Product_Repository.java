package ruchir.dev.product_service_24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruchir.dev.product_service_24.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface Product_Repository extends JpaRepository<Product, Long> {
    //Product Repo should contain all the methods related to Product Model

    List<Product> findByPriceIsGreaterThan(Double price);

    List<Product> findProductByTitleLike(String word); // Case sensitive
    //select * from products where title like '%iphone%'

    List<Product> findByTitleLikeIgnoreCase(String word); // wil make case insensitive.

    List<Product> findDistinctTop5ByTitleLikeIgnoreCase(String word);// Select * from product where title LIKE ' ' Limit 5

    Optional<Product> findById(Long id );

    @Override
    List<Product> findAll();
}


