package grupo2.Taller1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private String id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;

}
