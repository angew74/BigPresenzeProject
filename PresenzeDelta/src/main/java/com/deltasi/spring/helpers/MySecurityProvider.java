
package com.deltasi.spring.helpers;

import com.deltasi.presenze.contracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;



public class  MySecurityProvider implements ISecurityProvider {

    @Autowired
    IUserService userservice;

    public UserDetails getUserAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userDetails = (UserDetails) authentication.getPrincipal();
        }
        return userDetails;
    }

    public String getUserNameAuthenticathed() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String Username = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            Username = authentication.getName();
        }
        return Username;
    }
}
