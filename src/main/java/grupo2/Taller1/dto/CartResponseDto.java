package grupo2.Taller1.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CartResponseDto {
    private Long id;
    private Long userId;
    private LocalDateTime date;
    private List<CartProductDto> products;
    private Double totalAmount;
}
