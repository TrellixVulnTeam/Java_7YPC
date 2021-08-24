package www.commerce.controllers.api;

import org.springframework.web.bind.annotation.*;
import www.commerce.dto.CatalogDTO;
import www.commerce.dto.CategoryDTO;
import www.commerce.entities.Catalog;
import www.commerce.entities.Category;
import www.commerce.repositories.CatalogRepository;
import www.commerce.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CatalogController {

    private final CatalogRepository repository;
    private final CategoryRepository categoryRepository;


    CatalogController(CatalogRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/catalogs")
    List<CatalogDTO> all() {
        List<Catalog> startList = repository.findAll();
        List<CatalogDTO> list = new ArrayList<>();

        List<Category> category = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for (Category item : category){
            categoryDTOS.add(new CategoryDTO(item.getId(), item.getName(), item.getCatalog().getId()));
        }

        for (Catalog item : startList){

            List<CategoryDTO> tmp = new ArrayList<>();

            for(CategoryDTO i : categoryDTOS){
                if(item.getId() == i.getCatalogId())
                    tmp.add(i);
            }

            list.add(new CatalogDTO(item.getId(), item.getName(), tmp));
        }
        return list;
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
