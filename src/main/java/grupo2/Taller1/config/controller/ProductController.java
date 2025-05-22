package grupo2.Taller1.config.controller;


import grupo2.Taller1.config.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;


    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productService.findAll());

        return "products";
    }

}
