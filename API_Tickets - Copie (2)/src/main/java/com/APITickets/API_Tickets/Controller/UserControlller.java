package com.APITickets.API_Tickets.Controller;


import com.APITickets.API_Tickets.Module.Utilisateurs;
import com.APITickets.API_Tickets.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("User")
public class UserControlller {

    private UserService userService;

    @PostMapping("/Ajout")
    public Utilisateurs Creer(@RequestBody Utilisateurs user) {
        return userService.CreerUser(user);
    }

    @GetMapping("/Afficher")
    public List<Utilisateurs> Afficher() {
        return userService.AfficherUser();
    }

    @DeleteMapping("/Supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        return userService.SupUser(id);
    }

    @PutMapping("/update/{id}")
    public Utilisateurs updateUser(@PathVariable Long id, @RequestBody Utilisateurs user) {
        return userService.UpdateUser(id, user);
    }
}
