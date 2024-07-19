package ruchir.dev.product_service_24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruchir.dev.product_service_24.models.Category;

@Repository
public interface Category_Repository extends JpaRepository<Category, Long> {
    Category save(Category category);
}
