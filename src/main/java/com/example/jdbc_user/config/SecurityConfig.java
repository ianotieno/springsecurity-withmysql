package com.example.jdbc_user.config;

import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

//@Bean 
//InMemoryUserDetailsManager users(){
   // return new InMemoryUserDetailsManager(
     //User.withUsername("ian")
      //   .password("{noop}test")
       //  .roles("ADMIN")
       //  .build()
    //); 
//}
   @Bean
JdbcUserDetailsManager users(DataSource dataSource){
    JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager(dataSource);
    return  jdbcUserDetailsManager;
}


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
        return http
        .authorizeRequests(auth-> auth
        .anyRequest().authenticated()
        )
        .formLogin(Customizer.withDefaults())
        .build();
    }


}
