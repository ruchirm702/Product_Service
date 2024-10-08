package ruchir.dev.product_service_24.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ruchir.dev.product_service_24.models.Product;
import ruchir.dev.product_service_24.projections.ProductWithIdAndTitle;

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
    Page<Product> findAll(Pageable pageable);

    // HQL query to select product ID and title where ID is 1
    @Query("select p.id as id, p.title as title from Product p where p.id = 1")
    List<ProductWithIdAndTitle> randomSearchMethod();

    // SQL query to select product ID and title by product ID
    @Query(value = "select p.id as id, p.title as title from product p where p.id = :productId", nativeQuery = true)
    List<ProductWithIdAndTitle>  randomSearchMethodSQL(Long productId);

}