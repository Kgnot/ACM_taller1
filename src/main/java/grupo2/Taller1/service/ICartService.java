package grupo2.Taller1.service;

import grupo2.dto.CartResponseDto;
import java.util.List;

public interface ICartService {
    List<CartResponseDto> getCartsByUserId(Long userId);
    CartResponseDto getCartById(Long cartId);
}
