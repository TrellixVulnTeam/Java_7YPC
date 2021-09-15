package www.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import www.commerce.entities.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {

//   static Catalog getById(int id) {
//      return CatalogRepository.findById(id);
//   }

    Catalog findByName(String name);
}
