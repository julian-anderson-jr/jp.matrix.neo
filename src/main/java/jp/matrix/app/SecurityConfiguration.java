package jp.matrix.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * Security configuration. Defines configuration methods and security
 * constraints. Autowired bean definitions can be found in {@link AuthAppConfig}
 * 

 *
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
      // @formatter:off
      web
        .debug(true)
        .ignoring()
        .antMatchers("/images/**", "/js/**", "/css/**", "/**", "/root")
      ;
      // @formatter:on
    }

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    /*    http
        .authorizeRequests()
          .mvcMatchers("/", "/login", "/signedup").permitAll()
          .mvcMatchers("/members/user/**").hasRole("USER")
          .mvcMatchers("/members/admin/**").hasRole("ADMIN")
          .anyRequest().authenticated()
        .and()
        .formLogin()
          .defaultSuccessUrl("/")
        .and()
        .logout()
          .invalidateHttpSession(true)
          .deleteCookies("JSESSIONID")
          .logoutSuccessUrl("/")
        ;
    */
    }
    

    /**
     * Session Registry to store sessions
     * @return
     */
    @Bean
    SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

}