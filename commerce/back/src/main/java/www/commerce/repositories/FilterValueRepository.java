package www.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import www.commerce.entities.FilterValue;

public interface FilterValueRepository extends JpaRepository<FilterValue, Integer> {
}
