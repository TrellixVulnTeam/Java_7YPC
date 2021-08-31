package www.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import www.commerce.entities.DetailValue;

public interface DetailValuesRepository extends JpaRepository<DetailValue, Integer> {
}
