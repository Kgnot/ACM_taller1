package grupo2.Taller1.service;

import grupo2.Taller1.dto.LoginRequestDTO;
import grupo2.Taller1.dto.TokenResponseDTO;
import grupo2.Taller1.exception.InvalidCredentialsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/** Lógica de autenticación (consumo de API externa). */
@Service
@RequiredArgsConstructor
public class AuthService {

    private static final String LOGIN_URL = "https://fakestoreapi.com/auth/login";

    private final RestTemplate restTemplate;

    /**
     * Devuelve el token si las credenciales son correctas o lanza excepción.
     */
    public String authenticate(LoginRequestDTO dto) {
        try {
            ResponseEntity<TokenResponseDTO> response =
                    restTemplate.postForEntity(LOGIN_URL, dto, TokenResponseDTO.class);

            if (response.getStatusCode().is2xxSuccessful()
                    && response.getBody() != null
                    && response.getBody().getToken() != null) {
                return response.getBody().getToken();
            }
            throw new InvalidCredentialsException("Credenciales inválidas");
        } catch (HttpClientErrorException.Unauthorized e) {
            throw new InvalidCredentialsException("Credenciales inválidas");
        }
    }
}