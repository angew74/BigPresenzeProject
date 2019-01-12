/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AdminDSI
 */
@Entity
@Table(name = "curricula")
public class Curriculum {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "idcurriculum")  
   private Integer id;
   
   @Column(name = "nomefile")  
   private String nomefile;
   
   @Column(name = "estensione")  
   private String estensione;
   
   @Column(name = "versione")  
   private String versione;
   
   
   @Column(name = "file")  
   private String file;  
     
   @Column(name = "utenteope")  
   @NotNull
   @Size(max = 16, min = 8, message = "{persona.utente.invalido}")
   private String utente;   
   
   
   @Column(name = "dataope")  
   @NotNull 
   private Date dataope;    

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
     * @return the nomefile
     */
    public String getNomefile() {
        return nomefile;
    }

    /**
     * @param nomefile the nomefile to set
     */
    public void setNomefile(String nomefile) {
        this.nomefile = nomefile;
    }

    /**
     * @return the estensione
     */
    public String getEstensione() {
        return estensione;
    }

    /**
     * @param estensione the estensione to set
     */
    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

    /**
     * @return the versione
     */
    public String getVersione() {
        return versione;
    }

    /**
     * @param versione the versione to set
     */
    public void setVersione(String versione) {
        this.versione = versione;
    }

    /**
     * @return the file
     */
    public String getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(String file) {
        this.file = file;
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
    
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
  private Set<Persona> Persona = new HashSet<>();
    
}
