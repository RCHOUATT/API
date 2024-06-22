package com.APITickets.API_Tickets.Module;

import com.APITickets.API_Tickets.enums.RoleUsers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "BaseDeConnaissance")
public class BaseDeConnaissance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String reponse;

    @Enumerated(EnumType.ORDINAL)
    private RoleUsers roleUsers;
}
