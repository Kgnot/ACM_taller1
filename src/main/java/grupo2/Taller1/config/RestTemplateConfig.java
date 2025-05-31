package grupo2.Taller1.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

@Value("${fakestore.api.base-url:https://fakestoreapi.com}")
    private String baseUrl;
    
    public String getBaseUrl() {
        return baseUrl;
    }
    
    public String getCartsEndpoint() {
        return baseUrl + "/carts";
    }
    
    public String getProductsEndpoint() {
        return baseUrl + "/products";
    }
    
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder)
    {
        return builder
                .rootUri("https://fakestoreapi.com")
                .build();
    }

}
