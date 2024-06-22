package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.Ticket;
import com.APITickets.API_Tickets.enums.CategoryTicket;

import java.util.List;

public interface TicketService {

    /**
     * @param ticket
     * @return
     */
    Ticket CreerTicket(Ticket ticket);

    List<Ticket> AfficherTicket();

    String SupprimerTicket(Long id);

    Ticket UpdateTicket(Long id, Ticket ticket);

}