package grupo2.Taller1.mapper;

import com.example.dto.CartResponseDto;
import com.example.dto.CartProductDto;
import com.example.model.Cart;
import com.example.model.CartProduct;
import com.example.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    
    public CartResponseDto toDto(Cart cart, Map<Long, Product> productsMap) {
        if (cart == null) {
            return null;
        }
        
        List<CartProductDto> productDtos = cart.getProducts().stream()
            .map(cartProduct -> toCartProductDto(cartProduct, productsMap.get(cartProduct.getProductId())))
            .collect(Collectors.toList());
        
        Double totalAmount = productDtos.stream()
            .mapToDouble(CartProductDto::getSubtotal)
            .sum();
        
        return new CartResponseDto(
            cart.getId(),
            cart.getUserId(),
            cart.getDate(),
            productDtos,
            totalAmount
        );
    }
    
    public List<CartResponseDto> toDtoList(List<Cart> carts, Map<Long, Product> productsMap) {
        return carts.stream()
            .map(cart -> toDto(cart, productsMap))
            .collect(Collectors.toList());
    }
    
    private CartProductDto toCartProductDto(CartProduct cartProduct, Product product) {
        if (cartProduct == null) {
            return null;
        }
        
        String title = product != null ? product.getTitle() : "Producto no encontrado";
        Double price = product != null ? product.getPrice() : 0.0;
        String image = product != null ? product.getImage() : "";
        Double subtotal = price * cartProduct.getQuantity();
        
        return new CartProductDto(
            cartProduct.getProductId(),
            title,
            price,
            image,
            cartProduct.getQuantity(),
            subtotal
        );
    }
}
