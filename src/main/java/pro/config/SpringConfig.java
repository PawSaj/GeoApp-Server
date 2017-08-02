package pro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pro.dao.DaoConfig;
import pro.model.ModelConfig;
import pro.security.SecurityJavaConfig;
import pro.service.ServiceConfig;

@Configuration
@EnableWebMvc
@ComponentScan({"pro.security", "pro.controller", "pro.dao", "pro.service"})
@Import({ModelConfig.class, DaoConfig.class, ServiceConfig.class, SecurityJavaConfig.class})
public class SpringConfig extends WebMvcConfigurerAdapter {


}
