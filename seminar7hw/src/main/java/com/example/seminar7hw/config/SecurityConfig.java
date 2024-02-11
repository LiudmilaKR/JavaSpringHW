package com.example.seminar7hw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Класс SecurityConfig - конфигурация безопасности для аутентификации пользователей
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Метод определяет, какие url-адреса должны быть защищены, а какие нет
     * @param http url-адрес
     * @return простроенный фильтр адресов
     * @throws Exception ошибки идентификации
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((req) -> req
                        .requestMatchers("/home", "/").permitAll()
                        .requestMatchers("/public").hasAnyRole("USER")
                        .requestMatchers("/private").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin((form) -> form.defaultSuccessUrl("/home").permitAll())
                .logout((form) -> form.logoutSuccessUrl("/home"));
        return http.build();
    }

    /**
     * Метод настраивает хранилище данных для пользователей
     * @return хранимиые детали для пользователей
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user").password("{noop}pass").roles("USER").build();
        UserDetails admin = User.withUsername("admin").password("{noop}adm").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
