package www.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import www.commerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
