/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.spring.helpers;

import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Nick
 */
public interface ISecurityProvider {
      String getUserNameAuthenticathed();
      UserDetails getUserAuthenticated();
}
