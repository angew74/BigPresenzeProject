/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.model;

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
@Table(name = "users")
public class User {

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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the enaabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enaabled the enaabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
     public Set<Authorities> getAuthorities() {
        return authorities;
    }
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "user_id")  
   private Long id;
   
   @Column(name = "user_name")
   @NotNull
   @Size(max = 16, min = 3, message = "{utente.username.invalido}")
   private String username;
   
   @Column(name = "password")
   @NotNull
   @Size(max = 16, min = 6, message = "{utente.password.invalido}")
   private String password;
   
   
   @Column(name = "enabled")
   @NotNull 
   private boolean enabled;
   
   
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private Set<Authorities> authorities = new HashSet<>();

    
   
   
   
}
