package www.commerce.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import www.commerce.dto.catalog.CatalogDTO;
import www.commerce.dto.category.CategoryDTO;
import www.commerce.entities.Catalog;
import www.commerce.entities.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import www.commerce.entities.FilterName;
import www.commerce.entities.Product;
import www.commerce.repositories.CategoryRepository;
import www.commerce.service.MapStructMapper;


@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryRepository repository;
    private MapStructMapper mapstructMapper;

    CategoryController(CategoryRepository repository, MapStructMapper mapStructMapper) {
        this.repository = repository;
        this.mapstructMapper = mapStructMapper;
    }

    @GetMapping("/categories")
    ResponseEntity<List<CategoryDTO>> all() {
        return new ResponseEntity<List<CategoryDTO>>(
                mapstructMapper.categoriesToCategoryDTO(
                        repository.findAll()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/categories")
    ResponseEntity<Void> newCategory(@RequestBody CategoryDTO newCategory) {
        repository.save(
                mapstructMapper.categoryDTOToCategory(newCategory)
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @GetMapping("/categories/{id}")
    ResponseEntity<CategoryDTO> one(@PathVariable int id) {
        return new ResponseEntity<>(
                mapstructMapper.categoryToCategoryDTO(
                        repository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }

    @PutMapping("/categories/{id}")
    ResponseEntity<Void> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable int id) {
        Category category = repository.findById(id).get();

        List<Product> tmpProducts = category.getProducts();
        List<FilterName> tmpFilters = category.getFilters();

        category = mapstructMapper.categoryDTOToCategory(categoryDTO);

        if(category.getProducts() == null){
            category.setProducts(tmpProducts);
            category.setFilters(tmpFilters);
        }
        repository.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    void deleteCategory(@PathVariable int id) {
        repository.deleteById(id);
    }
}
