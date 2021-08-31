package www.commerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import www.commerce.dto.ProductDTO;
import www.commerce.entities.Product;
import www.commerce.repositories.ProductRepository;
import www.commerce.service.ProductService;

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
    public Product AddProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(int id, ProductDTO product) {
        Product productFromDB = productRepository.findById(id).get();
        productFromDB.setTitle(product.getTitle());

        productRepository.save(productFromDB);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}