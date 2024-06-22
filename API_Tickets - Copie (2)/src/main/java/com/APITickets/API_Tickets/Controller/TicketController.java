package com.APITickets.API_Tickets.Controller;


import com.APITickets.API_Tickets.Module.Ticket;
import com.APITickets.API_Tickets.Services.TicketServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("ticket")
public class TicketController {

    private TicketServiceImplement TicketService;

    @PostMapping("/Ajout")
    public Ticket Creer(@RequestBody Ticket ticket){
       return TicketService.CreerTicket(ticket);
    }

    @GetMapping("/Afficher")
    public List<Ticket> Afficher(){
        return TicketService.AfficherTicket();
    }

    @DeleteMapping("/Supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return TicketService.SupprimerTicket(id);
    }

    @PutMapping("/update/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket ticket){
        return TicketService.UpdateTicket(id, ticket);
    }

}
