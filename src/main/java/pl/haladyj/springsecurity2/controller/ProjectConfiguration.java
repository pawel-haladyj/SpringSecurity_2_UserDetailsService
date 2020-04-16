package pl.haladyj.springsecurity2.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.haladyj.springsecurity2.service.JPAUserDetailsService;

@Configuration
public class ProjectConfiguration {

    @Bean
    public UserDetailsService userDetailsService(){
        return new JPAUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
