package com.dbs.be.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

@OpenAPIDefinition(info = @Info(title = "[CI-CD] DBS APIs"))
@Configuration
public class SwaggerConfig implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(final ApplicationPreparedEvent event) {
        ConfigurableEnvironment environment = event.getApplicationContext().getEnvironment();
        Properties props = new Properties();
        props.put("springdoc.swagger-ui.path", swaggerPath());
        environment
                .getPropertySources()
                .addFirst(new PropertiesPropertySource("programmatically", props));
    }

    private String swaggerPath() {
        return "";
    }
}
