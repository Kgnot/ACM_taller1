package grupo2.Taller1.mapper;


import grupo2.Taller1.dto.ProductDto;
import grupo2.Taller1.model.Product;

import java.util.List;

public class ProductMapper {

    static ProductDto modelToDto(Product product) {

        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .category(product.getCategory())
                .image(product.getImage())
                .build();
    }


    public static Product dtoToModel(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .image(dto.getImage())
                .build();
    }

    // Los métodos para listas:

    public static List<ProductDto> modelToDtoList(List<Product> products) {
        return products.stream()
                .map(ProductMapper::modelToDto)
                .toList();
    }

    public static List<Product> dtoToModelList(List<ProductDto> dtos) {
        return dtos.stream()
                .map(ProductMapper::dtoToModel)
                .toList();
    }


}
