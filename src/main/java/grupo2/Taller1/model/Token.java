package grupo2.Taller1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Token {

    private String token;


    public boolean isPresent() {
        if(token == null) return false;

        return !token.isEmpty();
    }
}
