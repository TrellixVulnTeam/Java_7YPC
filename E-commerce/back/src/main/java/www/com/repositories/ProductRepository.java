package www.com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import www.com.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
