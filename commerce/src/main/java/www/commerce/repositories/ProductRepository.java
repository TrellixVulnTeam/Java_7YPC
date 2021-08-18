package www.commerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import www.commerce.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
