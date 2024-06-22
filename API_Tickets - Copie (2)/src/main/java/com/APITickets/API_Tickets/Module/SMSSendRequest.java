package com.APITickets.API_Tickets.Module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SMSSendRequest {

    private String senderNumber;
    private String message;
}
