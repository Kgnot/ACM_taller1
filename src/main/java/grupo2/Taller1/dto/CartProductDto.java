package grupo2.Taller1.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CartProductDto {
    private Long productId;
    private String title;
    private Double price;
    private String image;
    private Integer quantity;
    private Double subtotal;
}
