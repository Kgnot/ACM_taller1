package grupo2.Taller1.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestTemplateConfig {


    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder)
    {
        return builder
                .rootUri("https://fakestoreapi.com")
                .build();
    }

}
