package grupo2.Taller1.config.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private String id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;

}
