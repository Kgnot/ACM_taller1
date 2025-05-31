package grupo2.Taller1.controller;

import grupo2.Taller1.dto.CartResponseDto;
import grupo2.Taller1.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    
    @Autowired
    private ICartService cartService;
    
    GetMapping("/user/{userId}")
    public ResponseEntity<List<CartResponseDto>> getCartsByUserId(@PathVariable Long userId) {
        try {
            List<CartResponseDto> carts = cartService.getCartsByUserId(userId);
            return ResponseEntity.ok(carts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/{cartId}")
    public ResponseEntity<CartResponseDto> getCartById(@PathVariable Long cartId) {
        try {
            CartResponseDto cart = cartService.getCartById(cartId);
            if (cart != null) {
                return ResponseEntity.ok(cart);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
