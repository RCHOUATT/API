package com.APITickets.API_Tickets.Repository;

import com.APITickets.API_Tickets.Module.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;


public interface User_repository extends JpaRepository<Utilisateurs, Long>{
}
