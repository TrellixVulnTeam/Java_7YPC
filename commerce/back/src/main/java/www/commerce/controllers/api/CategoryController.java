package www.commerce.controllers.api;


import org.springframework.web.bind.annotation.*;
import www.commerce.entities.Category;

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
    List<Category> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/categories")
    Category newCategory(@RequestBody Category newCategory) {
        return repository.save(newCategory);
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
