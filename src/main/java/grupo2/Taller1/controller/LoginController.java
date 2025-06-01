package grupo2.Taller1.controller;

import grupo2.Taller1.dto.LoginRequestDTO;
import grupo2.Taller1.exception.InvalidCredentialsException;
import grupo2.Taller1.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;

    /* Muestra el formulario (ya tienes index.html con Thymeleaf). */
    @GetMapping({"/", "/login"})
    public String showForm(Model model) {
        model.addAttribute("loginRequestDTO", new LoginRequestDTO());
        return "index";          // nombre de tu template
    }

    /* Procesa el formulario. */
    @PostMapping("/api/v1")
    public String processLogin(
            @ModelAttribute("loginRequestDTO") @Valid LoginRequestDTO dto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "index";
        }

        try {
            String token = authService.authenticate(dto);      // LLamamos a la api
            model.addAttribute("jwt", token);
            return "redirect:/api/v1/products";
        } catch (InvalidCredentialsException e) {
            model.addAttribute("loginError", "Usuario o contraseña incorrectos.");
            return "index";
        } catch (Exception e) {                                // error de red, etc.
            model.addAttribute("loginError", "Error al contactar la API.");
            return "index";
        }
    }
}