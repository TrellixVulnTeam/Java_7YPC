package www.commerce.controllers.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import www.commerce.entities.Product;
import www.commerce.repositories.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

    //private final ProductRepository productRepository;

//    private final ProductService service;
//
//
//    @Autowired
//    public ProductController(ProductService productService) {
//        this.service = productService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Product>> getAllProducts() {
//        List<Product> products = service.getAll();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
//        Optional<Product> product = Optional.ofNullable(service.getProductById(id));
//
//        if (product.isPresent()) {
//            return new ResponseEntity<>(product.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        try {
//            Product newProduct = service.insert(new Product(product.getTitle()));
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.add("product", "api/product/" + String.valueOf(newProduct.getId()));
//            return new ResponseEntity<>(newProduct, httpHeaders, HttpStatus.CREATED);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    //@PutMapping({"/{id}"})
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id") int id, @RequestBody ProductDTO product) {
//
//        //Product update = new Product();
//        //update.setTitle(product.getTitle());
//        service.updateProduct(id, product);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//
//    @DeleteMapping({"/{id}"})
//    public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
//        service.deleteProduct(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    private final ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/products")
    List<Product> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/products")
    Product newCategory(@RequestBody Product newCategory) {
        return repository.save(newCategory);
    }

    // Single item

    @GetMapping("/products/{id}")
    Optional<Product> one(@PathVariable int id) {

        return repository.findById(id);
        //.orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/products/{id}")
    Product updateCategory (@RequestBody Product newProduct, @PathVariable int id) {

        return repository.findById(id)
                .map(product -> {
                    product.setTitle(newProduct.getTitle());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    product.setSale_price(newProduct.getSale_price());
                    product.setDiscount(newProduct.getDiscount());
                    product.setAvailability(newProduct.isAvailability());
                    product.setDetails(newProduct.getDetails());
                    product.setFilters(newProduct.getFilters());
                    product.setCategory(newProduct.getCategory());
                    product.setImages(newProduct.getImages());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteCategory(@PathVariable int id) {
        repository.deleteById(id);
    }



}
