/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

/**
 *
 * @author AdminDSI
 */
@Entity
@Table(name = "presenza")
public class Presenza {

    @Column(name = "utenteope")
    private String utente;

    @Column(name = "dataope")
    private Date dataope;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgiorno")
    private Integer id;

    @Column(name = "giorno")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date giorno;

    @Column(name = "oraentrata")
    private LocalDateTime oraentrata;

    @Column(name = "orauscita")
    private LocalDateTime orauscita;

    @Column(name = "pausapranzo")
    private int pausapranzo;

    @Column(name = "orepermesso")
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
    private int permessomalattiafiglio;

    @Transient
    private int userid;

    @Transient
    private String partialoraingresso;

    @Transient
    private String partialorauscita;

    public boolean IsEmpty() {
        return Stream.of(id, orauscita)
                .allMatch(Objects::isNull);
    }

    public boolean IsHalfEmpty() {
        boolean verify = false;
        if (id == null) {
            verify = false;
        }
        if (!verify) {
            return verify;
        }
        if (orauscita == null) {
            verify = true;
        }
        return verify;

    }

    public boolean IsFull() {
        return Stream.of(id, orauscita)
                .allMatch(Objects::nonNull);
    }

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
    public int getPermessomalattiafiglio() {
        return permessomalattiafiglio;
    }

    /**
     * @param permessomalattafiglio the permessomalattafiglio to set
     */
    public void setPermessomalattafiglio(int permessomalattafiglio) {
        this.permessomalattiafiglio = permessomalattafiglio;
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
    public String getPartialoraingresso() {
        if (StringUtils.isEmpty(partialoraingresso) && oraentrata != null) {
            StringBuilder str = new StringBuilder();
            return str.append(oraentrata.getHour())
                    .append(":")
                    .append(oraentrata.getMinute()).toString();

        } else {
            return partialoraingresso;
        }
    }

    /**
     * @param partialoraingresso the partialoraingresso to set
     */
    public void setPartialoraingresso(String partialoraingresso) {
        this.partialoraingresso = partialoraingresso;
    }

    @Transient
    public String getPartialorauscita() {
        if (StringUtils.isEmpty(partialorauscita) && orauscita != null) {
            StringBuilder str = new StringBuilder();
            return str.append(orauscita.getHour())
                    .append(":")
                    .append(orauscita.getMinute()).toString();

        } else {
            return partialorauscita;
        }
    }

    /**
     * @param partialorauscita the partialorauscita to set
     */
    public void setPartialorauscita(String partialorauscita) {
        this.partialorauscita = partialorauscita;
    }

    /**
     * @return the userid
     */
    @Transient
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }
}
