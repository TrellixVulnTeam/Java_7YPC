package www.commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import www.commerce.dto.catalog.CatalogDTO;
import www.commerce.dto.catalog.CatalogSlimDTO;
import www.commerce.dto.tmpCatalog;
import www.commerce.entities.Catalog;
import www.commerce.entities.Category;
import www.commerce.repositories.CatalogRepository;
import www.commerce.service.FilesStorageService;
import www.commerce.service.MapStructMapper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    private final CatalogRepository repository;
    private MapStructMapper mapstructMapper;

    @Autowired
    FilesStorageService storageService;


    CatalogController( MapStructMapper mapstructMapper, CatalogRepository repository
                       ) {
        this.repository = repository;
        this.mapstructMapper = mapstructMapper;
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
            CatalogDTO newCatalog = new CatalogDTO(catalog.getName(), catalog.getFile().getOriginalFilename());
            Catalog tmpCatalog = mapstructMapper.catalogDTOToCatalog(newCatalog);
            repository.save(tmpCatalog);

            MultipartFile file = catalog.getFile();
            storageService.save(file); // не дозволяє загрузити файли з однаковою назвою

//           message = "Uploaded the file successfully: " + file.getOriginalFilename();
            Catalog d = repository.findById(tmpCatalog.getId()).get();
            return new ResponseEntity<CatalogSlimDTO>(
                    mapstructMapper.catalogToCatalogSlimDTO(
                            repository.findById(tmpCatalog.getId()).get()
                    ),
                    HttpStatus.OK
            );
        }catch (Exception e) {
            message = "Cannot create catalog";
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
    void deleteCatalog(@PathVariable int id) throws IOException {
        Catalog deleteCatalog = repository.getById(id);
        Resource file = storageService.load(deleteCatalog.getImage());
        Files.delete(Paths.get(file.getFile().getPath()));

        repository.deleteById(id);
    }}
