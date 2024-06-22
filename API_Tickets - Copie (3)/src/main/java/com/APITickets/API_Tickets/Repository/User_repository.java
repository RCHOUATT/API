package com.APITickets.API_Tickets.Repository;

import com.APITickets.API_Tickets.Module.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface User_repository extends JpaRepository<Utilisateurs, Long>{
    Utilisateurs findByEmail(String email);
}
