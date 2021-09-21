package www.commerce.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import www.commerce.dto.file.FileInfo;
import www.commerce.entities.Catalog;
import www.commerce.entities.Catalog_Images;
import www.commerce.entities.Product_Images;
import www.commerce.repositories.CatalogImageRep;
import www.commerce.repositories.CatalogRepository;
import www.commerce.repositories.FileRepository;
import www.commerce.dto.auth.response.MessageResponse;
import www.commerce.service.FilesStorageService;
import www.commerce.service.MapStructMapper;


@Controller
@RequestMapping(path = "api/public")
public class FilesController {
    @Autowired
    FilesStorageService storageService;

    private FileRepository fileRepository;
    private MapStructMapper mapstructMapper;
    private CatalogImageRep catalogImageRep;

    private  CatalogRepository repository;


    public FilesController(MapStructMapper mapstructMapper, FileRepository fileRepository, CatalogImageRep catalogImageRep, CatalogRepository repository) {
        this.fileRepository = fileRepository;
        this.mapstructMapper = mapstructMapper;
        this.catalogImageRep = catalogImageRep;
        this.repository = repository;
    }

    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploaDFile(@RequestParam("files") List<MultipartFile> files) {
        String message = "";
        try {
            storageService.save(files.get(0));
            message = "Uploaded the file successfully: " + files.get(0).getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + files.get(0).getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<MessageResponse> uploadProductImage(@RequestParam("file") MultipartFile file, @PathVariable int id) {
        String message = "";
        try {
            storageService.save(file);
            AddToDB(file, id);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }
    private void AddToDB(MultipartFile file, int productId){
//        Product_Images image = new Product_Images();
//        image.setName(file.getOriginalFilename());

        //ImageProductDTO tmp = new ImageProductDTO(file.getOriginalFilename(), productId);

        Product_Images image = new Product_Images(file.getOriginalFilename(), productId);

        fileRepository.save(image);

    }

    @PostMapping("/upload/catalog/{id}")
    public ResponseEntity<MessageResponse> uploadCatalogImage(@RequestParam("file") MultipartFile file, @PathVariable int id) {
        String message = "";
        try {
            storageService.save(file);
            Catalog_Images image = new Catalog_Images(file.getOriginalFilename(), id);
            catalogImageRep.save(image);

            Catalog catalog = repository.findById(id).get();
            catalog.setImage(image);
            repository.save(catalog);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }



    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
