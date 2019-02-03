/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.spring.exception;

import org.springframework.stereotype.Component;

@Component
public class CustomException extends RuntimeException {
 
    private static final long serialVersionUID = 1L;
 
    private String errCode;
    private String errMsg;
 
    public CustomException() { }
 
    public CustomException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
 
    public String getErrCode() {
        return errCode;
    }
 
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
 
    public String getErrMsg() {
        return errMsg;
    }
 
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }   
}
