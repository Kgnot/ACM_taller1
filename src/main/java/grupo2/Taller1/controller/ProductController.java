package grupo2.Taller1.controller;


import grupo2.Taller1.model.Token;
import grupo2.Taller1.model.User;
import grupo2.Taller1.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService; // lo estoy inyectando
    private final Token token;

    @GetMapping
    public String getProducts(Model model) {



        model.addAttribute("products", productService.findAll()); // localstorage -> products : list<Products>

        return "products";
    }

}
