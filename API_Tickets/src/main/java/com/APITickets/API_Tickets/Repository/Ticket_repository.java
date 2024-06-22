package com.APITickets.API_Tickets.Repository;

import com.APITickets.API_Tickets.Module.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Ticket_repository extends JpaRepository<Ticket, Long>{
}
