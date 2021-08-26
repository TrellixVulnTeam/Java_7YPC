package www.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import www.commerce.entities.Product_Images;

public interface FileRepository extends JpaRepository<Product_Images, String> {
}
