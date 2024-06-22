package com.APITickets.API_Tickets.Security;

import com.APITickets.API_Tickets.Services.UserDetailServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class ConfigSecurityApp {

    private UserDetailServiceImplement userDetailServiceImplement;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return
                httpSecurity
                        .csrf(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests(
                                authorize -> authorize
                                        // Public endpoint
                                        .requestMatchers("/User/Ajout").permitAll()
                                        // User endpoints
                                        .requestMatchers("/User/Afficher").hasRole("Admin")
                                        .requestMatchers("/User/Supprimer/**").hasRole("Admin")
                                        .requestMatchers("/User/update/**").hasRole("Admin")
                                        // Base_de_connaissance endpoints
                                        .requestMatchers("/BDCon/Afficher").hasAnyRole("Admin", "Formateur")
                                        .requestMatchers("/BDCon/Supprimer/**").hasAnyRole("Admin", "Formateur")
                                        .requestMatchers("/BDCon/update/**").hasAnyRole("Admin", "Formateur")
                                        .requestMatchers("/BDCon/Ajout").hasAnyRole("Admin", "Formateur")
                                        // Ticket endpoints
                                        .requestMatchers("/ticket/Afficher").hasAnyRole("Admin", "Formateur", "Apprenant")
                                        .requestMatchers("/ticket/Supprimer/**").hasAnyRole("Admin", "Formateur", "Apprenant")
                                        .requestMatchers("/ticket/update/**").hasAnyRole("Admin", "Formateur", "Apprenant")
                                        .requestMatchers("/ticket/Ajout").hasAnyRole("Admin", "Formateur", "Apprenant")
                                        // Any other request must be authenticated
                                        .anyRequest().authenticated()
                        )
                        .httpBasic(withDefaults()) // Add basic HTTP authentication
                        .userDetailsService(userDetailServiceImplement)
                        .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
