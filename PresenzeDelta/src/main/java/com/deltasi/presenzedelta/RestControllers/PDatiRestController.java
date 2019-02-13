package com.deltasi.presenzedelta.RestControllers;

import com.deltasi.presenze.contracts.IPresenzaService;
import com.deltasi.presenze.model.DaylyPoint;
import com.deltasi.presenze.model.MonthlyPoint;
import com.deltasi.presenze.model.RiepilogoJson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pdati")
public class PDatiRestController {
    
    @Autowired
    IPresenzaService presenzaservice;
    
    @GetMapping("/mesi/{iduser}/{anno}")
    public MonthlyPoint getMesi(@PathVariable("iduser") int iduser, @PathVariable("anno") int idanno) {
        Map<String, String> errors = null;
        MonthlyPoint mese = new MonthlyPoint();
        try {
            List<MonthlyPoint> m = presenzaservice.getMesePresenzeByUserId(iduser, idanno);
            if (m.size() > 0) {
                mese = m.get(0);
            }
            mese.setValidated(true);
        } catch (Exception ex) {
              errors = new HashMap<String, String>();
                    errors.put("Errrore in banca dati", ex.getMessage());
            mese.setValidated(false);
            mese.setErrorMessages(errors);
        }
        return mese;
    }
    
    @GetMapping("/giorni/{iduser}/{mese}")
    public List<DaylyPoint> getGiorni(@PathVariable("iduser") int iduser, @PathVariable("mese") int idmese) {
        Map<String, String> errors = null;    
         List<DaylyPoint> m = null;
        try {
             m = presenzaservice.getGiornoPresenzeByUserId(iduser, idmese);     
        } catch (Exception ex) {
              errors = new HashMap<String, String>();
                    errors.put("Errrore in banca dati", ex.getMessage());            
        }
        return m;
    }
}
