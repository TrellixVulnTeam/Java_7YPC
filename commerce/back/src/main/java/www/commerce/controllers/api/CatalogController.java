package www.commerce.controllers.api;

import org.springframework.web.bind.annotation.*;
import www.commerce.entities.Catalog;
import www.commerce.repositories.CatalogRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CatalogController {

    private final CatalogRepository repository;

    CatalogController(CatalogRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/catalogs")
    List<Catalog> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/catalogs")
    Catalog newCatalog(@RequestBody Catalog newCatalog) {
        return repository.save(newCatalog);
    }

    // Single item

    @GetMapping("/catalogs/{id}")
    Optional<Catalog> one(@PathVariable int id) {

        return repository.findById(id);
                //.orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/catalogs/{id}")
    Catalog updateCatalog(@RequestBody Catalog newCatalog, @PathVariable int id) {

        return repository.findById(id)
                .map(catalog -> {
                    catalog.setName(newCatalog.getName());
                    return repository.save(catalog);
                })
                .orElseGet(() -> {
                    newCatalog.setId(id);
                    return repository.save(newCatalog);
                });
    }

    @DeleteMapping("/catalogs/{id}")
    void deleteCatalog(@PathVariable int id) {
        repository.deleteById( id);
    }
}
