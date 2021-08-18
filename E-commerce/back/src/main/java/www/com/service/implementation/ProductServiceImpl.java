package www.com.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import www.com.dto.ProductDTO;
import www.com.entities.Product;
import www.com.repositories.ProductRepository;
import www.com.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
        //return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product insert(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(int id, ProductDTO product) {
        Product productFromDB = productRepository.findById(id).get();

        //productFromDB.setBrand(product.getBrand());
        //productFromDB.setAvailability(product.get());
//        productFromDB.setCategory(product.getCategory());
//        productFromDB.setDescription(product.getDescription());
//        productFromDB.setDetails(product.getDetails());
//        productFromDB.setDiscount(product.getDiscount());
//        productFromDB.setImages(product.getImages());
//        productFromDB.setNotes(product.getNotes());
//        productFromDB.setSale_price(product.getSale_price());
        productFromDB.setTitle(product.getTitle());
//        productFromDB.setLink(product.getLink());
//        productFromDB.setPrice(product.getPrice());

        productRepository.save(productFromDB);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}