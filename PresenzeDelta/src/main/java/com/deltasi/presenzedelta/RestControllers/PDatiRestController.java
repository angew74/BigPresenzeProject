package com.deltasi.presenzedelta.RestControllers;

import com.deltasi.presenze.contracts.IPresenzaService;
import com.deltasi.presenze.contracts.IUserService;
import com.deltasi.presenze.model.DaylyPoint;
import com.deltasi.presenze.model.MonthlyPoint;
import com.deltasi.presenze.model.Presenza;
import com.deltasi.presenze.model.PresenzaJson;
import com.deltasi.presenze.model.RiepilogoJson;
import com.deltasi.presenze.model.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pdati")
public class PDatiRestController {

    @Autowired
    IPresenzaService presenzaservice;
    
    @Autowired
    IUserService userservice;

    @GetMapping("/mesi/{iduser}/{anno}")
    @Secured("ROLE_ADMIN,ROLE_USER")
    public List<MonthlyPoint> getMesi(@PathVariable("iduser") int iduser, @PathVariable("anno") int idanno) {
        Map<String, String> errors = null;
        List<MonthlyPoint> m = null;
        try {
            m = presenzaservice.getMesePresenzeByUserId(iduser, idanno);           
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        return m;
    }

    @GetMapping("/giorni/{iduser}/{mese}")
    @Secured("ROLE_ADMIN,ROLE_USER")
    public List<DaylyPoint> getGiorni(@PathVariable("iduser") int iduser, @PathVariable("mese") int idmese) {       
        List<DaylyPoint> m = null;
        try {
            m = presenzaservice.getGiornoPresenzeByUserId(iduser, idmese);
            if (m == null) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Risorsa non trovata", null);
            }
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        return m;
    }

  
    @GetMapping("/giorno/{id}")
   @Secured("ROLE_ADMIN,ROLE_USER")
    public Presenza getGiorno(@PathVariable("id") int id) {
        Presenza p = null;
        try {
            p = presenzaservice.getPresenza(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        return p;
    }
    
      @GetMapping("/checkuser/{username}")
   @Secured("ROLE_ADMIN")
    public User checkUser(@PathVariable("username") String username) {
        User u = null;
        try {
            u = userservice.getByUsername(username);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        return u;
    }
}
