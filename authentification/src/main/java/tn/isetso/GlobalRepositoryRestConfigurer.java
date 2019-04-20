package tn.isetso;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import tn.isetso.entities.Role;
import tn.isetso.entities.Users;

@Configuration
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    super.configureRepositoryRestConfiguration(config);
    config.getCorsRegistry()
        .addMapping("/**")
        .allowedOrigins("http//localhost:4200")
        .allowedHeaders("*")
        .allowedMethods("*");
    config.exposeIdsFor(Users.class, Role.class);
  }
}
