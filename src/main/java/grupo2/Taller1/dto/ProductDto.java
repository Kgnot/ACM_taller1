package grupo2.Taller1.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class ProductDto {

    private Integer id;
    private String title;
    private Float price;
    private String description;
    private String category;
    private String image;

}
