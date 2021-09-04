package www.commerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import www.commerce.dto.catalog.CatalogDTO;
import www.commerce.dto.product.ProductDTO;
import www.commerce.entities.DetailValue;
import www.commerce.entities.FilterValue;
import www.commerce.entities.Product;
import www.commerce.entities.Product_Images;
import www.commerce.repositories.ProductRepository;
import www.commerce.service.MapStructMapper;
import www.commerce.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService service;
    private MapStructMapper mapstructMapper;


    @Autowired
    public ProductController(MapStructMapper mapstructMapper,ProductService productService, ProductRepository productRepository) {
        this.service = productService;
        this.productRepository = productRepository;
        this.mapstructMapper = mapstructMapper;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<List<ProductDTO>>(mapstructMapper.productsToProductDTO((productRepository.findAll())), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") int id) {
        return new ResponseEntity<ProductDTO>(mapstructMapper.productToProductDTO(productRepository.getById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO) {
       productRepository.save(mapstructMapper.productDTOToProduct(productDTO));
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") int id, @RequestBody ProductDTO productDTO) {
        Product product = productRepository.getById(id);

        List<DetailValue> detailValues = product.getDetails();
        List<FilterValue> filterValues = product.getFilters();
        List<Product_Images> product_images = product.getImages();

        product = mapstructMapper.productDTOToProduct(productDTO);

        if(product.getDetails() == null){
            product.setDetails(detailValues);
            product.setImages(product_images);
            product.setFilters(filterValues);
        }
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Integer> deleteProduct(@PathVariable("id") int id) {
        service.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
