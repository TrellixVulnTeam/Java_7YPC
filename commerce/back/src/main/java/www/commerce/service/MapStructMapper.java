package www.commerce.service;

import org.mapstruct.Mapper;
import www.commerce.dto.*;
import www.commerce.entities.*;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {



    CategoryDTO categoryToCategoryDTO(Category category);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);
    Category categorySlimDTOToCategory(CategorySlimDTO categoryDTO);

    CategorySlimDTO categoryToCategorySlimDTO(Category category);



    CatalogDTO catalogToCatalogDTO(Catalog catalog);

    Catalog catalogDTOToCatalog(CatalogDTO catalogDTO);

    CatalogSlimDTO catalogToCatalogSlimDTO(Catalog catalog);

    Catalog catalogSlimDTOToCatalog(CatalogSlimDTO catalogSlimDTO);

    //CatalogAllDto authorToAuthorAllDto(Author author);

    List<CatalogDTO> catalogsToCatalogDTO(List<Catalog> catalogs);



    ImageProductDTO imageToImageDTO(Product_Images image);

    Product_Images imageDTOToImage(ImageProductDTO image);


    List<ProductDTO> productsToProductDTO(List<Product> products);

    Product productDTOToProduct(ProductDTO productDTO);

    ProductDTO productToProductDTO(Product product);


    DetailValue DetailValueDTOToDetailValue(DetailValueDTO detailValueDTO);
    DetailValueDTO DetailValueToDetailValueDTO(DetailValue detailValue);

    DetailName DetailNameDTOToDetailName(DetailNameDTO detailNameDTO);
    DetailNameDTO DetailNameToDetailNameDTO(DetailName detailName);

    //UserGetDto userToUserGetDto(User user);

    //User userPostDtoToUser(UserPostDto userPostDto);
}
