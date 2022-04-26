package com.fatec.sigx.adapters;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.sigx.model.Produto;
import com.fatec.sigx.ports.MantemProduto;

@Controller
@RequestMapping(path = "/sig")
public class GUIProdutoController {
	Logger logger = LogManager.getLogger(GUIProdutoController.class);
	@Autowired
	MantemProduto mantemProduto;
	
	@GetMapping("/produto")
	public ModelAndView retornaFormDeCadastroDe(Produto produto) {
		ModelAndView mv = new ModelAndView("cadastrarProduto");
		mv.addObject("produto", produto);
		return mv;
	}
	/**
	 * Cadastra o produto no banco de dados
	 * Se houver erro na entrada de dados da interface (result.hasErros() ) nao sai da tela de cadastro
	 * Se nao tenta salvar retorna consulta todos, ou retorna dados invalidos (prod ja cadastrado)
	 * @param produto
	 * @param result - informações de erros na entrada de dados
	 * @return - a tela que deve ser apresentada ao usuario (cadastro ou consulta)
	 */
	@PostMapping("/produtos")
	public ModelAndView save(@Valid Produto produto, BindingResult result) {
		logger.info(">>>>>> controller metodo save chamado => " + result.hasErrors() );
		ModelAndView mv = new ModelAndView("consultarProduto");
		if (result.hasErrors()) {
			mv.setViewName("cadastrarProduto");
		}else {
			if (produto.getDescricao()=="") {
				logger.info(">>>>>> controller chamou save e consulta todos");
				mv.addObject("produtos", mantemProduto.consultaTodos());
			} else {
				logger.info(">>>>>> controller cadastrar com dados invalidos");
				mv.setViewName("cadastrarProduto");
				mv.addObject("message", "Dados invalidos");
			}
		}
		return mv;
	}
	@GetMapping("/produtos")
	public ModelAndView retornaFormDeConsultaTodosProdutos() {
		logger.info(">>>>>> controller consulta todos chamado" );
		ModelAndView mv = new ModelAndView("consultarProduto");
		mv.addObject("produtos", mantemProduto.consultaTodos());
		return mv;
	}
}
