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
import javax.validation.constraints.Size;

/**
 *
 * @author Accademia
 */
@Entity
@Table(name = "documentoqualita")
public class Documento {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "iddocqualita")  
   private Integer id;
   
   @Column(name = "nomefile")  
   private String nomefile;
   
   @Column(name = "tipologicadoc")  
   private String tipologicadoc;
    
   @Column(name = "estensionefile")  
   private String estensione;
   
   @Column(name = "versione")  
   private String versione;
   
   
   @Column(name = "file",columnDefinition="BLOB")      
   private byte[] file;  
     
   @Column(name = "utenteope")  
   @NotNull
   @Size(max = 16, min = 8, message = "{persona.utente.invalido}")
   private String utente;   
   
   
   @Column(name = "dataope")  
   @NotNull 
   private Date dataope;    
   
   /*
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoqualita")
  private Set<Authorities> authorities = new HashSet<>();
*/
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
     * @return the tipologicadoc
     */
    public String getTipologicadoc() {
        return tipologicadoc;
    }

    /**
     * @param tipologicadoc the tipologicadoc to set
     */
    public void setTipologicadoc(String tipologicadoc) {
        this.tipologicadoc = tipologicadoc;
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
    public byte[] getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(byte[] file) {
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

   /*
    public Set<Authorities> getAuthorities() {
        return authorities;
    }

   
    public void setAuthorities(Set<Authorities> authorities) {
        this.authorities = authorities;
    }*/

}
