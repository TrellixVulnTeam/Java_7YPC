package www.commerce.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import www.commerce.dto.CatalogDTO;
import www.commerce.entities.Catalog;
import www.commerce.entities.Category;
import www.commerce.repositories.CatalogRepository;
import www.commerce.service.MapStructMapper;


import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    private final CatalogRepository repository;
    private MapStructMapper mapstructMapper;

    CatalogController( MapStructMapper mapstructMapper, CatalogRepository repository) {
        this.repository = repository;
        this.mapstructMapper = mapstructMapper;
    }

    @GetMapping("/catalogs")
    ResponseEntity<List<CatalogDTO>> all() {
        return new ResponseEntity<List<CatalogDTO>>(
                mapstructMapper.catalogsToCatalogDTO(
                        repository.findAll()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/catalogs")
    ResponseEntity<Void> newCatalog(@RequestBody CatalogDTO newCatalog) {
        repository.save(
                mapstructMapper.catalogDTOToCatalog(newCatalog)
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/catalogs/{id}")
    ResponseEntity<CatalogDTO> one(@PathVariable int id) {
        return new ResponseEntity<>(
                mapstructMapper.catalogToCatalogDTO(
                        repository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }

    @PutMapping("/catalogs/{id}")
    ResponseEntity<Void> updateCatalog(@RequestBody CatalogDTO newCatalog, @PathVariable int id) {
        Catalog catalog = repository.findById(id).get();
        List<Category> tmp = catalog.getCategories();
        catalog = mapstructMapper.catalogDTOToCatalog(newCatalog);
        if(catalog.getCategories() == null){
            catalog.setCategories(tmp);
        }
        repository.save(catalog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/catalogs/{id}")
    void deleteCatalog(@PathVariable int id) {
        repository.deleteById( id);
    }
}
