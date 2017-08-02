package pro.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"pro.dao"})
@ComponentScan(basePackages = {"pro.dao"})
public class DaoConfig {

}
