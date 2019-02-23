/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.spring.helpers;

import com.deltasi.presenze.model.Presenza;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.StringUtils;

/**
 *
 * @author Nick
 */
public class PBusinessRules {
    
    public Map<String, String> ValidatePresenza(Presenza presenza)
    {
        Map<String, String> errors = null;
        String convingresso;
        String convuscita;
         if(StringUtils.isEmpty(presenza.getOraentrata()) || presenza.getOraentrata() == null)
                {convingresso = "0.0";}
                else {convingresso = presenza.getOraentrata().replace(':', '.');}
                Double ingresso = NumberUtils.toDouble(convingresso);
                if(StringUtils.isEmpty(presenza.getOrauscita()) || presenza.getOrauscita() == null)
                {convuscita = "0.0";}
                else {convuscita = presenza.getOrauscita().replace(':', '.');}     
                Double uscita = NumberUtils.toDouble(convuscita);
                String f = presenza.getFerie();
                String m = presenza.getMalattia();
                if (uscita != 0) {
                    int orepermesso = presenza.getOrepermesso();
                    int pausapranzo = presenza.getPausapranzo();
                    int permessomaternita = presenza.getPermessomaternita();
                    int pmalattiafiglio = presenza.getPermessomalattiafiglio();
                    double orepranzo = pausapranzo / 60;
                    Double orecomplessive = uscita - ingresso + orepermesso - orepranzo + permessomaternita + pmalattiafiglio;
                    if (Math.round(orecomplessive) != 8) {
                        errors = new HashMap<String, String>();
                        errors.put("Errrore in banca dati", "Totale deve essere di 8 ore");                       
                    }
                    presenza.setMalattia("N");
                    presenza.setFerie("N");
                } 
                if (uscita == 0 && ingresso != 0) {
                    presenza.setMalattia("N");
                    presenza.setFerie("N");
                }
                if (f.trim().toUpperCase().equals("S") || m.trim().toUpperCase().equals("S"))
                {
                    presenza.setOraentrata("00:00");
                    presenza.setOrauscita("00:00");
                    if (f.equals("S")) {
                        presenza.setMalattia("N");                        
                    } else {
                        presenza.setFerie("N");
                    }
                }
               return  errors;                
    }
}
