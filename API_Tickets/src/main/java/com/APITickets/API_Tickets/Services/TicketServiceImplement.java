package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.Ticket;
import com.APITickets.API_Tickets.Repository.Ticket_repository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;



import java.util.List;

@AllArgsConstructor
@Service
@Data
public class TicketServiceImplement implements TicketService {

    private Ticket_repository ticketRepository;

    @Override
    public Ticket CreerTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> AfficherTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public String SupprimerTicket(Long id) {
        ticketRepository.deleteById(id);
        return "Ticket " + id + " Ticket avec succès";
    }

    @Override
    public Ticket UpdateTicket(Long id, Ticket ticket) {
        return ticketRepository.findById(id)
                    .map(p -> {
                        p.setTitre(ticket.getTitre());
                        p.setDescription(ticket.getDescription());
                        p.setStatus(ticket.getStatus());
                        return ticketRepository.save(p);
                    }).orElseThrow(() -> new RuntimeException("Ticket " + id + " non trouvé" ));
    }
}