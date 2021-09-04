package www.commerce.seader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import www.commerce.entities.*;
import www.commerce.repositories.*;

import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private CatalogRepository catalogRepository;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private DetailsNameRepository detailsNameRepository;
    private DetailValuesRepository detailValuesRepository;
    private FilterNameRepository filterNameRepository;
    private FilterValueRepository filterValueRepository;

    public DatabaseLoader(CatalogRepository catalogRepository,
                          CategoryRepository categoryRepository, ProductRepository productRepository,
                          DetailsNameRepository detailsNameRepository,
                          DetailValuesRepository detailValuesRepository,
                          FilterNameRepository filterNameRepository, FilterValueRepository filterValueRepository) {
        this.catalogRepository = catalogRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.detailsNameRepository = detailsNameRepository;
        this.detailValuesRepository = detailValuesRepository;
        this.filterNameRepository = filterNameRepository;
        this.filterValueRepository = filterValueRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.catalogRepository.count()==0){
            this.catalogRepository.save(new Catalog("Sound and Music"));
        }
        if(this.categoryRepository.count()==0){
            this.categoryRepository.save(new Category("Headphones", 1));
        }


        if(this.detailsNameRepository.count()==0){
            this.detailsNameRepository.save(new DetailName("Connect", false));
        }
        if(this.detailValuesRepository.count()==0){
            this.detailValuesRepository.save(new DetailValue("Bluetooth", false, 1));
        }
        if(this.filterNameRepository.count()==0){
            this.filterNameRepository.save(new FilterName("Type", false, false, 1));
        }
        if(this.filterValueRepository.count()==0){
            this.filterValueRepository.save(new FilterValue("Wireless", false, false, 1));
        }

        List<DetailValue> details = this.detailValuesRepository.findAll();
        List<FilterValue> filters = this.filterValueRepository.findAll();

        if(this.productRepository.count()==0){
            this.productRepository.save(new Product("Pro headphones", "blabla", "...", 1, 1, 1, true, 1));
            this.productRepository.save(new Product("headphones", "gfd", "...", 1, 1, 1, true, 1, details, filters));
        }

    }
}
