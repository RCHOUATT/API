package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.Ticket;
import com.APITickets.API_Tickets.Module.Utilisateurs;
import com.APITickets.API_Tickets.enums.CategoryTicket;

import java.util.List;

public interface UserService {

    Utilisateurs CreerUser(Utilisateurs user);

    List<Utilisateurs> AfficherUser();

    String SupUser(Long id);

    Utilisateurs UpdateUser(Long id, Utilisateurs user);

}