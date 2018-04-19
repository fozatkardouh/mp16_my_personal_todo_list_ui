package at.refugeescode.mp16_my_personal_todo_list_ui.initialise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Starter {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
