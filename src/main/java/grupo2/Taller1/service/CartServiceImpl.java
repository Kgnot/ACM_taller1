package grupo2.Taller1.service

import grupo2.Taller1.config.RestTemplateConfig;
import grupo2.Taller1.dto.CartResponseDto;
import grupo2.Taller1.mapper.CartMapper;
import grupo2.Taller1.model.Cart;
import grupo2.Taller1.model.CartProduct;
import grupo2.Taller1.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private RestTemplateConfig apiConfig;
    
    @Autowired
    private CartMapper cartMapper;
    
    @Autowired
    private ObjectMapper objectMapper;

  @Override
    public List<CartResponseDto> getCartsByUserId(Long userId) {
        try {
            String url = apiConfig.getCartsEndpoint() + "/user/" + userId;
            Cart[] cartsArray = restTemplate.getForObject(url, Cart[].class);
            List<Cart> carts = Arrays.asList(cartsArray != null ? cartsArray : new Cart[0]);
            
            Set<Long> productIds = carts.stream()
                .flatMap(cart -> cart.getProducts().stream())
                .map(CartProduct::getProductId)
                .collect(Collectors.toSet());
            
            Map<Long, Product> productsMap = getProductsMap(productIds);
            
            return cartMapper.toDtoList(carts, productsMap);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los carritos del usuario " + userId + ": " + e.getMessage(), e);
        }
    }
    
    @Override
    public CartResponseDto getCartById(Long cartId) {
        try {
            String url = apiConfig.getCartsEndpoint() + "/" + cartId;
            Cart cart = restTemplate.getForObject(url, Cart.class);
            
            if (cart == null) {
                return null;
            }
            
            Set<Long> productIds = cart.getProducts().stream()
                .map(CartProduct::getProductId)
                .collect(Collectors.toSet());
            
            Map<Long, Product> productsMap = getProductsMap(productIds);
            
            return cartMapper.toDto(cart, productsMap);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el carrito " + cartId + ": " + e.getMessage(), e);
        }
    }
    
    private Map<Long, Product> getProductsMap(Set<Long> productIds) {
        Map<Long, Product> productsMap = new HashMap<>();
        
        for (Long productId : productIds) {
            try {
                String url = apiConfig.getProductsEndpoint() + "/" + productId;
                Product product = restTemplate.getForObject(url, Product.class);
                if (product != null) {
                    productsMap.put(productId, product);
                }
            } catch (Exception e) {
                System.err.println("Error al obtener producto " + productId + ": " + e.getMessage());
            }
        }
        
        return productsMap;
    }
}
