package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.BaseDeConnaissance;
import com.APITickets.API_Tickets.Repository.BaseCon_repository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Data
public class BaseConImplement implements BaseConService {

    private BaseCon_repository baseCon_repository;


    @Override
    public BaseDeConnaissance creer(BaseDeConnaissance BaseDeConn) {
        return baseCon_repository.save(BaseDeConn);
    }

    @Override
    public List<BaseDeConnaissance> AfficherBC(){
        return baseCon_repository.findAll();
    }

    @Override
    public  String SuppBC(Long id) {
        baseCon_repository.deleteById(id);
        return "Base de connaissance " + id + " est supprimée avec succès";
    }

    @Override
    public BaseDeConnaissance UpdateBC(Long id, BaseDeConnaissance BaseDeConn){
        return baseCon_repository.findById(id)
                    .map(p -> {
                        p.setQuestion(BaseDeConn.getQuestion());
                        p.setReponse(BaseDeConn.getReponse());
                        p.setRole(BaseDeConn.getRole());
                        return baseCon_repository.save(p);
                    }).orElseThrow(() -> new RuntimeException("Base de connaissance " + id + " non trouvé" ));
    }
}