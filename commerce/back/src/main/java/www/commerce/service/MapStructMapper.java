package www.commerce.service;

import org.mapstruct.Mapper;
import www.commerce.dto.catalog.CatalogDTO;
import www.commerce.dto.catalog.CatalogSlimDTO;
import www.commerce.dto.category.CategoryDTO;
import www.commerce.dto.category.CategorySlimDTO;
import www.commerce.dto.detail.DetailNameDTO;
import www.commerce.dto.detail.DetailValueDTO;
import www.commerce.dto.filter.FilterNameDTO;
import www.commerce.dto.filter.FilterValueDTO;
import www.commerce.dto.product.ImageProductDTO;
import www.commerce.dto.product.ProductDTO;
import www.commerce.entities.*;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    //categories
    CategoryDTO categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(CategoryDTO categoryDTO);
    Category categorySlimDTOToCategory(CategorySlimDTO categoryDTO);
    //CategorySlimDTO categoryToCategorySlimDTO(Category category);
    List<CategoryDTO> categoriesToCategoryDTO(List<Category> categories);

    //catalogs
    CatalogDTO catalogToCatalogDTO(Catalog catalog);
    Catalog catalogDTOToCatalog(CatalogDTO catalogDTO);
    CatalogSlimDTO catalogToCatalogSlimDTO(Catalog catalog);
    Catalog catalogSlimDTOToCatalog(CatalogSlimDTO catalogSlimDTO);
    List<CatalogDTO> catalogsToCatalogDTO(List<Catalog> catalogs);
    //images
    ImageProductDTO imageToImageDTO(Product_Images image);
    Product_Images imageDTOToImage(ImageProductDTO image);
    //products
    List<ProductDTO> productsToProductDTO(List<Product> products);
    Product productDTOToProduct(ProductDTO productDTO);
    ProductDTO productToProductDTO(Product product);
    //details
    DetailValue DetailValueDTOToDetailValue(DetailValueDTO detailValueDTO);
    DetailValueDTO DetailValueToDetailValueDTO(DetailValue detailValue);
    DetailName DetailNameDTOToDetailName(DetailNameDTO detailNameDTO);
    DetailNameDTO DetailNameToDetailNameDTO(DetailName detailName);
    List<DetailNameDTO> DetailsNameToDetailNameDTO(List<DetailName> detailNames);
    //filters
    FilterName FilterNameDTOToFilterName(FilterNameDTO filterNameDTO);
    FilterNameDTO FilterNameToFilterNameDTO(FilterName filterName);
    FilterValue FilterValueDTOToFilterValue(FilterValueDTO filterValueDTO);
    FilterValueDTO FilterValueToFilterValueDTO(FilterValue filterValue);




}
