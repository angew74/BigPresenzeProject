/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.model;

import java.util.Map;

public class MonthlyPoint {

    private Integer anno;
    private Integer mese;
    private Integer giorno;  
    private Long totale;
    private Integer iduser;
    private String username;
    private boolean validated;
    private Map<String, String> errorMessages;

    /**
     * @return the anno
     */
    public Integer getAnno() {
        return anno;
    }

    /**
     * @param anno the anno to set
     */
    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    /**
     * @return the mese
     */
    public Integer getMese() {
        return mese;
    }

    /**
     * @param mese the mese to set
     */
    public void setMese(Integer mese) {
        this.mese = mese;
    }

    /**
     * @return the totale
     */
    public Long getTotale() {
        return totale;
    }

    /**
     * @param totale the totale to set
     */
    public void setTotale(Long totale) {
        this.totale = totale;
    }

    /**
     * @return the IdUser
     */
    public Integer getIdUser() {
        return iduser;
    }

    /**
     * @param IdUser the IdUser to set
     */
    public void setIdUser(Integer IdUser) {
        this.iduser = IdUser;
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
     * @return the giorno
     */
    public Integer getGiorno() {
        return giorno;
    }

    /**
     * @param giorno the giorno to set
     */
    public void setGiorno(Integer giorno) {
        this.giorno = giorno;
    }

  
}
