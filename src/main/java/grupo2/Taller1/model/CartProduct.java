package grupo2.Taller1.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CartProduct {
    private Long productId;
    private Integer quantity;
}
