package grupo2.Taller1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

// Este es el apartado de usuario, lo más importante es que sea a quien se le piden las llamadas
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    private Long id;
    private Token token;
}
