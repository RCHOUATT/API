package com.APITickets.API_Tickets.Services;


import com.APITickets.API_Tickets.Module.BaseDeConnaissance;

import java.util.List;

public interface BaseConService {

    BaseDeConnaissance creer(BaseDeConnaissance BaseDeConn);

    List<BaseDeConnaissance> AfficherBC();

    String SuppBC(Long id);

    BaseDeConnaissance UpdateBC(Long id, BaseDeConnaissance BaseDeConn);


}
