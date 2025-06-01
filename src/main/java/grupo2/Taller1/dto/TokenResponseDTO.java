package grupo2.Taller1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/** La API de FakeStore responde { "token": "…" }. */
@Data
@NoArgsConstructor
public class TokenResponseDTO {
    private String token;
}