package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.Utilisateurs;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserDetailServiceImplement implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateurs user = userService.loadUserByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", email));
        }

        UserDetails userDetails = User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name().substring(5)) // Remove 'ROLE_' prefix as hasRole() adds it automatically
                .build();
        return userDetails;
    }
}
