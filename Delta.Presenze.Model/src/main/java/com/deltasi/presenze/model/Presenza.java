/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AdminDSI
 */
@Entity
@Table(name = "presenza")
public class Presenza {

    @Column(name = "utenteope")
    @NotNull
    @Size(max = 16, min = 8, message = "{persona.utente.invalido}")
    private String utente;

    @Column(name = "dataope")
    @NotNull
    private Date dataope;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgiorno")
    private Integer id;

    @Column(name = "giorno")
    @NotNull
    private Date giorno;

    @Column(name = "oraentrata")
    private LocalDateTime oraentrata;

    @Column(name = "orauscita")
    private LocalDateTime orauscita;

    @Column(name = "pausapranzo")
    private int pausapranzo;

    @Column(name = "ore permesso")
    private int orepermesso;

    @Column(name = "permessomaternita")
    private int permessomaternita;

    @Column(name = "congedoparentale")
    private int congedoparentale;

    @Column(name = "malattia")
    private String malattia;

    @Column(name = "ferie")
    private String ferie;

    @Column(name = "permessomalattiafiglio")
    private int permessomalattafiglio;
    
    @Transient
    private int iduser;
    
    @Transient
    private String partialoraingresso;
    
    @Transient
    private String partialorauscita;

    /**
     * @return the utente
     */
    public String getUtente() {
        return utente;
    }

    /**
     * @param utente the utente to set
     */
    public void setUtente(String utente) {
        this.utente = utente;
    }

    /**
     * @return the dataope
     */
    public Date getDataope() {
        return dataope;
    }

    /**
     * @param dataope the dataope to set
     */
    public void setDataope(Date dataope) {
        this.dataope = dataope;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the giorno
     */
    public Date getGiorno() {
        return giorno;
    }

    /**
     * @param giorno the giorno to set
     */
    public void setGiorno(Date giorno) {
        this.giorno = giorno;
    }

    /**
     * @return the oraentrata
     */
    public LocalDateTime getOraentrata() {
        return oraentrata;
    }

    /**
     * @return the orauscita
     */
    public LocalDateTime getOrauscita() {
        return orauscita;
    }

    /**
     * @param oraentrata the oraentrata to set
     */
    public void setOraentrata(LocalDateTime oraentrata) {
        this.oraentrata = oraentrata;
    }

    /**
     * @param orauscita the orauscita to set
     */
    public void setOrauscita(LocalDateTime orauscita) {
        this.orauscita = orauscita;
    }

    /**
     * @return the pausapranzo
     */
    public int getPausapranzo() {
        return pausapranzo;
    }

    /**
     * @param pausapranzo the pausapranzo to set
     */
    public void setPausapranzo(int pausapranzo) {
        this.pausapranzo = pausapranzo;
    }

    /**
     * @return the orepermesso
     */
    public int getOrepermesso() {
        return orepermesso;
    }

    /**
     * @param orepermesso the orepermesso to set
     */
    public void setOrepermesso(int orepermesso) {
        this.orepermesso = orepermesso;
    }

    /**
     * @return the permessomaternita
     */
    public int getPermessomaternita() {
        return permessomaternita;
    }

    /**
     * @param permessomaternita the permessomaternita to set
     */
    public void setPermessomaternita(int permessomaternita) {
        this.permessomaternita = permessomaternita;
    }

    /**
     * @return the congedoparentale
     */
    public int getCongedoparentale() {
        return congedoparentale;
    }

    /**
     * @param congedoparentale the congedoparentale to set
     */
    public void setCongedoparentale(int congedoparentale) {
        this.congedoparentale = congedoparentale;
    }

    /**
     * @return the malattia
     */
    public String getMalattia() {
        return malattia;
    }

    /**
     * @param malattia the malattia to set
     */
    public void setMalattia(String malattia) {
        this.malattia = malattia;
    }

    /**
     * @return the ferie
     */
    public String getFerie() {
        return ferie;
    }

    /**
     * @param ferie the ferie to set
     */
    public void setFerie(String ferie) {
        this.ferie = ferie;
    }

    /**
     * @return the permessomalattafiglio
     */
    public int getPermessomalattafiglio() {
        return permessomalattafiglio;
    }

    /**
     * @param permessomalattafiglio the permessomalattafiglio to set
     */
    public void setPermessomalattafiglio(int permessomalattafiglio) {
        this.permessomalattafiglio = permessomalattafiglio;
    }
    @ManyToOne()
    @JoinColumn(name = "iduser")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        this.user = u;
    }

  
    @Transient
    public int getIduser() {
        return iduser;
    }

    /**
     * @param iduser the iduser to set
     */
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

   
    @Transient
    public String getPartialoraingresso() {
        return partialoraingresso;
    }

    /**
     * @param partialoraingresso the partialoraingresso to set
     */
    public void setPartialoraingresso(String partialoraingresso) {
        this.partialoraingresso = partialoraingresso;
    }

    @Transient
    public String getPartialorauscita() {
        return partialorauscita;
    }

    /**
     * @param partialorauscita the partialorauscita to set
     */
    public void setPartialorauscita(String partialorauscita) {
        this.partialorauscita = partialorauscita;
    }
}
