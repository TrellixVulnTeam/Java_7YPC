package www.commerce.controllers.api;


import org.springframework.web.bind.annotation.*;
import www.commerce.dto.CatalogDTO;
import www.commerce.dto.CategoryDTO;
import www.commerce.entities.Catalog;
import www.commerce.entities.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import www.commerce.repositories.CategoryRepository;


@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryRepository repository;

    CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/categories")
    List<CategoryDTO> all() {
        List<Category> startList = repository.findAll();
        List<CategoryDTO> list = new ArrayList<>();
        for (Category item : startList){
            list.add(new CategoryDTO(item.getId(), item.getName(), item.getCatalog().getId()));
        }
        return list;

    }
    // end::get-aggregate-root[]

    @PostMapping("/categories")
    Category newCategory(@RequestBody CategoryDTO newCategory) {

        Category category = new Category(newCategory.getName(), newCategory.getCatalogId());
        return repository.save(category);
    }


    // Single item

    @GetMapping("/categories/{id}")
    Optional<Category> one(@PathVariable int id) {

        return repository.findById(id);
        //.orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/categories/{id}")
    Category updateCategory (@RequestBody Category newCategory, @PathVariable int id) {

        return repository.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    category.setCatalog(newCategory.getCatalog());
                    return repository.save(category);
                })
                .orElseGet(() -> {
                    newCategory.setId(id);
                    return repository.save(newCategory);
                });
    }

    @DeleteMapping("/categories/{id}")
    void deleteCategory(@PathVariable int id) {
        repository.deleteById(id);
    }
}
