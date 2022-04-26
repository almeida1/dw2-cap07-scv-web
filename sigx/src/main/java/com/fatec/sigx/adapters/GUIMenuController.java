package com.fatec.sigx.adapters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class GUIMenuController {
	Logger logger = LogManager.getLogger(GUIMenuController.class);
	@GetMapping("/login")
	public ModelAndView autenticacao() {
		logger.info(">>>>>> controller metodo autenticacao chamado" );
		return new ModelAndView("paginaLogin");
	}

	@GetMapping("/")
	public ModelAndView home() {
		logger.info(">>>>>> controller metodo home chamado" );
		return new ModelAndView ("paginaMenu");
	}

}

