package ruchir.dev.product_service_24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruchir.dev.product_service_24.models.Category;

@Repository // Marks this interface as a Spring Data repository

public interface Category_Repository extends JpaRepository<Category, Long> {

    // Inherited save method from JpaRepository
    Category save(Category category);
}
