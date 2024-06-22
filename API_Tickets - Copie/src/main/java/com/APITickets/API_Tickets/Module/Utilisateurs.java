package com.APITickets.API_Tickets.Module;

import com.APITickets.API_Tickets.enums.Role;
import com.APITickets.API_Tickets.enums.TypeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class    Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String email;

    @Enumerated(EnumType.ORDINAL)
    private Role role;
}
