package www.com.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import www.com.dto.ProductDTO;
import www.com.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getProductById(int id);

    Product insert(Product product);

    void updateProduct(int id, ProductDTO product);

    void deleteProduct(int id);
}
