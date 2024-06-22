package com.APITickets.API_Tickets.Module;

import com.APITickets.API_Tickets.enums.CategoryTicket;
import com.APITickets.API_Tickets.enums.TypeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Enumeration;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private Date date = new Date();

    @Enumerated(EnumType.ORDINAL)
    private TypeStatus status;

    @Enumerated(EnumType.ORDINAL)
    private CategoryTicket Category;


}
