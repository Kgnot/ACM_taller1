package grupo2.Taller1.service;

import grupo2.Taller1.dto.ProductDto;
import grupo2.Taller1.mapper.ProductMapper;
import grupo2.Taller1.model.Product;
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
    public List<Product> findAll() {

        ProductDto[] stockDto =
                restTemplate.getForObject("/products", ProductDto[].class);
        if (stockDto == null) {
            return List.of();
        }
        List<Product> stock = ProductMapper.dtoToModel(List.of(stockDto));

        log.info("Product list size: {}", stock.size()); // no ponemos tdo porque bueno, xd

        return stockDto.length == 0 ? List.of() : stock;
    }
}
