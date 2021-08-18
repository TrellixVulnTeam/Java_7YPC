package www.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import www.com.entities.Product;
import www.com.repositories.ProductRepository;

import java.util.List;


public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);

    void sendMimeMessage(String to,
                           String subject,
                           String text);


}
