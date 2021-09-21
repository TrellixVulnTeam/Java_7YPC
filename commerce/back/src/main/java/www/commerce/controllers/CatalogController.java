package www.commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import www.commerce.dto.auth.response.MessageResponse;
import www.commerce.dto.catalog.CatalogDTO;
import www.commerce.dto.catalog.CatalogSlimDTO;
import www.commerce.dto.tmpCatalog;
import www.commerce.entities.Catalog;
import www.commerce.entities.Catalog_Images;
import www.commerce.entities.Category;
import www.commerce.repositories.CatalogImageRep;
import www.commerce.repositories.CatalogRepository;
import www.commerce.service.FilesStorageService;
import www.commerce.service.MapStructMapper;


import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    private final CatalogRepository repository;
    private MapStructMapper mapstructMapper;

    @Autowired
    FilesStorageService storageService;
    private CatalogImageRep catalogImageRep;


    CatalogController( MapStructMapper mapstructMapper, CatalogRepository repository,
                       CatalogImageRep catalogImageRep) {
        this.repository = repository;
        this.mapstructMapper = mapstructMapper;
        this.catalogImageRep = catalogImageRep;
    }

    @GetMapping("/catalogs")
    ResponseEntity<List<CatalogDTO>> all() {
        return new ResponseEntity<List<CatalogDTO>>(
                mapstructMapper.catalogsToCatalogDTO(
                        repository.findAll()
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/catalogs-slim")
    ResponseEntity<List<CatalogSlimDTO>> all_slim() {
        return new ResponseEntity<List<CatalogSlimDTO>>(
                mapstructMapper.catalogsToCatalogsSlimDTO(
                        repository.findAll()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/catalogs")
    ResponseEntity<CatalogSlimDTO> newCatalog(@RequestBody CatalogDTO newCatalog) {
        repository.save(
                mapstructMapper.catalogDTOToCatalog(newCatalog)
        );

        return new ResponseEntity<>(
                mapstructMapper.catalogToCatalogSlimDTO(
                        repository.findByName(newCatalog.getName())
                ),
                HttpStatus.OK
        );

//        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @PostMapping(value = "/catalog", consumes = { "multipart/form-data" })
    ResponseEntity<CatalogSlimDTO> createCatalog(
//            @RequestParam("name") String name,
//               @RequestParam("file") MultipartFile file
//            @RequestBody tmpCatalog catalog
            @ModelAttribute tmpCatalog catalog
    ) {


        String message = "";
        try{
            CatalogDTO newCatalog = new CatalogDTO(catalog.getName());
            repository.save(mapstructMapper.catalogDTOToCatalog(newCatalog));


            Catalog tmpCatalog = repository.findByName(newCatalog.getName());

            MultipartFile file = catalog.getFile();

            storageService.save(file); // не дозволяє загрузити файли з однаковою назвою

            String fileName = catalog.getFile().getOriginalFilename();
            int catalogId = tmpCatalog.getId();

            Catalog_Images image = new Catalog_Images(fileName, catalogId);
            catalogImageRep.save(image);

            tmpCatalog.setImage(image);
            repository.save(tmpCatalog);

//            message = "Uploaded the file successfully: " + file.getOriginalFilename();

            return new ResponseEntity<>(
                    mapstructMapper.catalogToCatalogSlimDTO(
                            repository.findByName(newCatalog.getName())
                    ),
                    HttpStatus.OK
            );
        }catch (Exception e) {
            message = "Cannot create catalog";
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/catalogs/{id}")
    ResponseEntity<CatalogDTO> one(@PathVariable int id) {
        return new ResponseEntity<>(
                mapstructMapper.catalogToCatalogDTO(
                        repository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/catalog/{id}")
    ResponseEntity<CatalogSlimDTO> getById(@PathVariable int id) {
        return new ResponseEntity<>(
                mapstructMapper.catalogToCatalogSlimDTO(
                        repository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }


    @PutMapping("/catalogs/{id}")
    ResponseEntity<Void> updateCatalog(@RequestBody CatalogDTO newCatalog, @PathVariable int id) {
        Catalog catalog = repository.findById(id).get();
        List<Category> tmp = catalog.getCategories();
        catalog = mapstructMapper.catalogDTOToCatalog(newCatalog);
        if(catalog.getCategories() == null){
            catalog.setCategories(tmp);
        }
        repository.save(catalog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/catalogs/{id}")
    void deleteCatalog(@PathVariable int id) {
        repository.deleteById(id);
    }
}
