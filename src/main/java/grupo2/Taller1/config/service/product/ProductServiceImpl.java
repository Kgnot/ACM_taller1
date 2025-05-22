package grupo2.Taller1.config.service.product;

import grupo2.Taller1.config.dto.ProductDto;
import grupo2.Taller1.config.mapper.ProductMapper;
import grupo2.Taller1.config.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final RestTemplate restTemplate;

    @Override
    public List<ProductDto> findAll() {

        Product[] productList =
                restTemplate.getForObject("/products", Product[].class);
        if(productList == null)
        {
            return List.of();
        }
        List<ProductDto> productDto = ProductMapper.modelToDtoList(List.of(productList));

        log.info("Product list size: {}", productDto.size()); // no ponemos tdo porque bueno, xd

        return productDto.isEmpty() ? List.of() : productDto;
    }
}
