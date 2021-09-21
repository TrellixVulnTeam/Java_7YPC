package www.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import www.commerce.entities.Catalog_Images;

public interface CatalogImageRep extends JpaRepository<Catalog_Images, String> {
}
