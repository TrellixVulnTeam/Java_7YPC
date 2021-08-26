package www.commerce.service;

import org.mapstruct.Mapper;
import www.commerce.dto.CatalogDTO;
import www.commerce.dto.CategoryDTO;
import www.commerce.dto.CategorySlimDTO;
import www.commerce.dto.ImageProductDTO;
import www.commerce.entities.Catalog;
import www.commerce.entities.Category;
import www.commerce.entities.Product_Images;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    CategorySlimDTO categoryToCategorySlimDTO(Category category);

    CategoryDTO categoryToCategoryDTO(Category category);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);

    CatalogDTO catalogToCatalogDTO(Catalog catalog);

    Catalog catalogDTOToCatalog(CatalogDTO catalogDTO);

    //CatalogAllDto authorToAuthorAllDto(Author author);

    List<CatalogDTO> catalogsToCatalogDTO(List<Catalog> catalogs);



    ImageProductDTO imageToImageDTO(Product_Images image);

    Product_Images imageDTOToImage(ImageProductDTO image);

    //UserGetDto userToUserGetDto(User user);

    //User userPostDtoToUser(UserPostDto userPostDto);
}
