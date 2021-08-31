package www.commerce.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import www.commerce.dto.ProductDTO;
import www.commerce.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getProductById(int id);

    Product AddProduct(Product product);

    void updateProduct(int id, ProductDTO product);

    void deleteProduct(int id);
}
