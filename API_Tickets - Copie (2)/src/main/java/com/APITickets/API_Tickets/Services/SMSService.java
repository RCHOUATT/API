package com.APITickets.API_Tickets.Services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSService {

    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;

    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    String OUTGOING_SMS_NUMBER;

    @PostConstruct
    private void init() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
    public String sendSMS(String phoneNumber, String smsmessage) {

        Message message = Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(OUTGOING_SMS_NUMBER),
                smsmessage).create();
        return message.getStatus().toString();
    }
}
