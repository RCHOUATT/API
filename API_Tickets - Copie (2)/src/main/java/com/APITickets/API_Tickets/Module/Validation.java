package com.APITickets.API_Tickets.Module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant creation;
    private Instant expiration;
    private Instant activation;
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    private Utilisateurs utilisateur;

}
