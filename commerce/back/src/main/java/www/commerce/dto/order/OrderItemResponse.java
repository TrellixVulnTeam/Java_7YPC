package www.commerce.dto.order;

import lombok.Data;
import www.commerce.dto.product.ProductDTO;

@Data
public class OrderItemResponse {
    private Long id;
    private Long amount;
    private Long quantity;
    private ProductDTO product;
}
