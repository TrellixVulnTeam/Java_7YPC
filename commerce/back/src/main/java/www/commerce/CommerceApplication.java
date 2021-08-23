package www.commerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableConfigurationProperties(StorageProperties.class)
public class CommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommerceApplication.class, args);
    }

//    @Bean
//    CommandLineRunner init(StorageService storageService) {
//        return(args) -> {
//            try {
//                //storageService.init();
//            }
//            catch(Exception ex) {
//                System.out.println("-----Problem---");
//            }
//        };
//    }
}