package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.Utilisateurs;
import com.APITickets.API_Tickets.Repository.User_repository;
import com.APITickets.API_Tickets.enums.RoleUsers;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Data
public class UserServiceImplement implements UserService {

    private final User_repository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private ValidationServiceImplement validationServiceImplement;


    public Utilisateurs CreerUser(Utilisateurs user){
            if(!user.getEmail().contains("@") || !user.getEmail().contains(".")){
                throw new RuntimeException("Votre email est incorrect.");
            }

            String mdpCrypt = bCryptPasswordEncoder.encode(user.getMdp());
            user.setMdp(mdpCrypt);
            user.setRole(RoleUsers.Admin);
            Utilisateurs uitlisateur = userRepository.save(user);
            validationServiceImplement.enregistrer(uitlisateur);
            return uitlisateur;
    }

    @Override
    public List<Utilisateurs> AfficherUser(){
        return userRepository.findAll();
    }

    @Override
    public String SupUser(Long id){
        userRepository.deleteById(id);
        return "Utilisateur " + id + " supprimé avec succès";
    }

    @Override
    public Utilisateurs UpdateUser(Long id, Utilisateurs user){
        return userRepository.findById(id)
                .map(p -> {
                    p.setNom(user.getNom());
                    p.setEmail(user.getEmail());
                    p.setRole(user.getRole());
                    return userRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Nous avons rencontré un problème lors de la mise à jour de " + id));
    }

    @Override
    public Utilisateurs loadUserByUsername(String email){
        return userRepository.findByEmail(email);
    }
}
