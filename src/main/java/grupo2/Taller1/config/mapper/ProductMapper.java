package grupo2.Taller1.config.mapper;


import grupo2.Taller1.config.dto.ProductDto;
import grupo2.Taller1.config.model.Product;

import java.util.List;

public interface ProductMapper {

    static ProductDto modelToDto(Product product) {
        return grupo2.Taller1.config.dto.ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .category(product.getCategory())
                .image(product.getImage())
                .build();
    }


    static Product dtoToModel(grupo2.Taller1.config.dto.ProductDto dto) {
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

    static List<ProductDto> modelToDtoList(List<Product> products) {
        return products.stream()
                .map(ProductMapper::modelToDto)
                .toList();
    }

    static List<Product> dtoToModel(List<ProductDto> dtos) {
        return dtos.stream()
                .map(ProductMapper::dtoToModel)
                .toList();
    }


}
