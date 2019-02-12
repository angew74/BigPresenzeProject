/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.model;

import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author Nick
 */
public class DaylyPoint {
    
    private Integer idgiorno;
    private Integer iduser;
    private String username;
    private boolean validated;
    private Map<String, String> errorMessages;
    private LocalDate datagiorno;
      
        /**
     * @return the idgiorno
     */
    public Integer getIdgiorno() {
        return idgiorno;
    }

    /**
     * @param idgiorno the idgiorno to set
     */
    public void setIdgiorno(Integer idgiorno) {
        this.idgiorno = idgiorno;
    }

    /**
     * @return the iduser
     */
    public Integer getIduser() {
        return iduser;
    }

    /**
     * @param iduser the iduser to set
     */
    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return the datagiorno
     */
    public LocalDate getDatagiorno() {
        return datagiorno;
    }

    /**
     * @param datagiorno the datagiorno to set
     */
    public void setDatagiorno(LocalDate datagiorno) {
        this.datagiorno = datagiorno;
    }
}
