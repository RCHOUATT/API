package com.APITickets.API_Tickets.Controller;

import com.APITickets.API_Tickets.Module.BaseDeConnaissance;
import com.APITickets.API_Tickets.Services.BaseConService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("BDCon")
public class BCController {
  private BaseConService baseConService;

    @PostMapping("/Ajout")
    public BaseDeConnaissance Creer(@RequestBody BaseDeConnaissance BaseDeConn){
       return baseConService.creer(BaseDeConn);
    }

    @GetMapping("/Afficher")
    public List<BaseDeConnaissance> Afficher() {
        return baseConService.AfficherBC();
    }

    @DeleteMapping("/Supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        return baseConService.SuppBC(id);
    }

    @PutMapping("/update/{id}")
    public BaseDeConnaissance update(@PathVariable Long id, @RequestBody BaseDeConnaissance BaseDeConn) {
        return baseConService.UpdateBC(id, BaseDeConn);
    }
}
