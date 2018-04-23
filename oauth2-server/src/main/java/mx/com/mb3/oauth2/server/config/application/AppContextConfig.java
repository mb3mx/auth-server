package mx.com.mb3.oauth2.server.config.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({
    "classpath:/service-context.xml", 
    "classpath:/dao-context.xml"
})
public class AppContextConfig {
	
	
}
