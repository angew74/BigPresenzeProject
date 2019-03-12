/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.model;

import java.util.Map;

/**
 *
 * @author AdminDSI
 */
public class AnagraficaJsonResponse {
   private Persona anagrafica;
   private boolean validated;
   private Map<String, String> errorMessages;

    /**
     * @return the anagrafica
     */
    public Persona getAnagrafica() {
        return anagrafica;
    }

    /**
     * @param anagrafica the anagrafica to set
     */
    public void setAnagrafica(Persona anagrafica) {
        this.anagrafica = anagrafica;
    }

    /**
     * @return the validated
     */
    public boolean isValidated() {
        return validated;
    }

    /**
     * @param validated the validated to set
     */
    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    /**
     * @return the errorMessages
     */
    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * @param errorMessages the errorMessages to set
     */
    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
