package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.Utilisateurs;
import com.APITickets.API_Tickets.Module.Validation;
import com.APITickets.API_Tickets.Repository.ValidationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
public class ValidationServiceImplement implements ValidationService {


    private ValidationRepository validationRepository;

    public void enregistrer(Utilisateurs utilisateur){
        Validation validation = new Validation();
        validation.setUtilisateur(utilisateur);

        Instant creationDate = Instant.now();
        Instant expirationDate = creationDate.plus(10, MINUTES);

        validation.setCreation(creationDate);
        validation.setExpiration(expirationDate);

        Random random = new Random();

        int randomInt = random.nextInt(999999);
        String code = String.format("%06d", randomInt);
        validation.setCode(code);

        validationRepository.save(validation);
    }

}
