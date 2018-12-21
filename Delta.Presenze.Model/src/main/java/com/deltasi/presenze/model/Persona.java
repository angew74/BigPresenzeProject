/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;



/**
 *
 * @author AdminDSI
 */

@Entity
@Table(name = "persona")
public class Persona {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")  
   private Long id;

      
   @Column(name = "nome")
   @NotNull
   @Size(max = 90, min = 3, message = "{persona.nome.invalido}")
   private String nome;
   
   @Column(name = "cognome")
   @NotNull
   @Size(max = 90, min = 3, message = "{persona.cognome.invalido}")
   private String cognome;
   
   @Column(name = "sesso")
   @NotNull
   @Size(max = 1, min = 1, message = "{persona.sesso.invalido}")
   private String sesso;
   
   @Column(name = "codicefiscale")  
   @Size(max = 16, min = 16, message = "{persona.codicefiscale.invalido}")
   private String codicefiscale;
   
   @Column(name = "comunenascita")  
   @Size(max = 3, min = 90, message = "{persona.comunenascita.invalido}")
   private String comunenascita;   
   
    @Column(name = "statonascita")  
   @Size(max = 3, min = 90, message = "{persona.statonascita.invalido}")
   private String statonascita;   
   
   @Column(name = "cittadinanza")  
   @Size(max = 3, min = 90, message = "{persona.cittadinanza.invalido}")
   private String cittadinanza;   
   
   
   @Column(name = "utenteope")  
   @NotNull
   @Size(max = 16, min = 8, message = "{persona.utente.invalido}")
   private String utente;   
   
   
   @Column(name = "dataope")  
   @NotNull 
   private Date dataope;   
   
   
   @Column(name = "datanascita")  
   @Past
   @NotNull
   private Date datanascita;   
   

   @Column(name = "mailpersonale", unique = true)
   @Email(message = "{persona.mailpersonale.invalido}")
   private String mailpersonale;
   
   @Column(name = "mailaziendale", unique = true)
   @Size(max = 90, min = 5, message = "{persona.mailaziendale.invalido}")
   @Email(message = "{persona.email.invalido}")
   private String mailaziendale;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the sesso
     */
    public String getSesso() {
        return sesso;
    }

    /**
     * @param sesso the sesso to set
     */
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    /**
     * @return the codicefiscale
     */
    public String getCodicefiscale() {
        return codicefiscale;
    }

    /**
     * @param codicefiscale the codicefiscale to set
     */
    public void setCodicefiscale(String codicefiscale) {
        this.codicefiscale = codicefiscale;
    }

    /**
     * @return the comunenascita
     */
    public String getComunenascita() {
        return comunenascita;
    }

    /**
     * @param comunenascita the comunenascita to set
     */
    public void setComunenascita(String comunenascita) {
        this.comunenascita = comunenascita;
    }

    /**
     * @return the statonascita
     */
    public String getStatonascita() {
        return statonascita;
    }

    /**
     * @param statonascita the statonascita to set
     */
    public void setStatonascita(String statonascita) {
        this.statonascita = statonascita;
    }

    /**
     * @return the cittadinanza
     */
    public String getCittadinanza() {
        return cittadinanza;
    }

    /**
     * @param cittadinanza the cittadinanza to set
     */
    public void setCittadinanza(String cittadinanza) {
        this.cittadinanza = cittadinanza;
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
     * @return the datanascita
     */
    public Date getDatanascita() {
        return datanascita;
    }

    /**
     * @param datanascita the datanascita to set
     */
    public void setDatanascita(Date datanascita) {
        this.datanascita = datanascita;
    }

    /**
     * @return the mailpersonale
     */
    public String getMailpersonale() {
        return mailpersonale;
    }

    /**
     * @param mailpersonale the mailpersonale to set
     */
    public void setMailpersonale(String mailpersonale) {
        this.mailpersonale = mailpersonale;
    }

    /**
     * @return the mailaziendale
     */
    public String getMailaziendale() {
        return mailaziendale;
    }

    /**
     * @param mailaziendale the mailaziendale to set
     */
    public void setMailaziendale(String mailaziendale) {
        this.mailaziendale = mailaziendale;
    }

}

