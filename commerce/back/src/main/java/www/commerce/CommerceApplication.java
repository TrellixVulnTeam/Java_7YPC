package www.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import www.commerce.service.FilesStorageService;
import org.springframework.boot.CommandLineRunner;


import javax.annotation.Resource;

@SpringBootApplication
public class CommerceApplication implements CommandLineRunner{

    @Resource
    FilesStorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(CommerceApplication.class, args);
    }

    @Override
    public void run(String... arg) throws Exception {
        storageService.deleteAll();
        storageService.init();
    }

}
