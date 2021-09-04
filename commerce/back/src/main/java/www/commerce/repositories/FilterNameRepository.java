package www.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import www.commerce.entities.FilterName;

public interface FilterNameRepository extends JpaRepository<FilterName, Integer> {
}
