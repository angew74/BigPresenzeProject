/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenzedelta.Controllers;

import com.deltasi.spring.exception.CustomException;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	@RequestMapping(value= "/exception/{type}", method= RequestMethod.GET)
	public String exception(@PathVariable(name="type") String exception) throws IOException {

		if (exception.equalsIgnoreCase("error")) {			
			throw new CustomException("A1001", "Messaggio per l'amministratore.");
		} else if (exception.equalsIgnoreCase("io-error")) {			
			throw new IOException();
		} else {
			return "success";
		}
	}

	@ExceptionHandler(CustomException.class)
	public ModelAndView handleMyException(CustomException mex) {

		ModelAndView model = new ModelAndView();
		model.addObject("errCode", mex.getErrCode());
		model.addObject("errMsg", mex.getErrMsg());
		model.setViewName("common/error");
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {

		ModelAndView model = new ModelAndView();
		model.addObject("errMsg", "errore nell'applicazione dettagli: " + ex.getMessage());
		model.setViewName("common/error");
		return model;

	}
}
