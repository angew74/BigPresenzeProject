/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.model;

import java.util.Map;

/**
 *
 * @author Nick
 */
public class PresenzeJsonResponse {
   private User user;
   private boolean validated;
   private Map<String, String> errorMessages;
   private Presenza presenza;

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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

    /**
     * @return the presenza
     */
    public Presenza getPresenza() {
        return presenza;
    }

    /**
     * @param presenza the presenza to set
     */
    public void setPresenza(Presenza presenza) {
        this.presenza = presenza;
    }

}
