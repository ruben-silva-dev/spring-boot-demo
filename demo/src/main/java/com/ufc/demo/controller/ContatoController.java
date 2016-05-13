package com.ufc.demo.controller;

import static com.ufc.demo.util.Constants.CONTATO;
import static com.ufc.demo.util.Constants.CONTATOS;
import static com.ufc.demo.util.Constants.PAGINA_LISTAR_CONTATOS;
import static com.ufc.demo.util.Constants.REDIRECT_LISTAR_CONTATOS;
import static com.ufc.demo.util.Constants.REFRESH_TABELA_CONTATOS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ufc.demo.model.Contato;
import com.ufc.demo.service.IContatoService;

@Controller
@RequestMapping("contato")
@Transactional
public class ContatoController {
	
	@Autowired
	private IContatoService contatoService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getContatos(){
		return PAGINA_LISTAR_CONTATOS;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String adicionar(Contato contato){
		contatoService.salvar(contato);
		return REDIRECT_LISTAR_CONTATOS;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String remover(Contato contato, Model model){
		contatoService.apagar(contato);
		model.addAttribute(CONTATOS, popularContatos());
		return REFRESH_TABELA_CONTATOS;
		
	}
	
	@ModelAttribute(CONTATOS)
	public List<Contato> popularContatos(){
		return this.contatoService.getContatos();
	}
	
	@ModelAttribute(CONTATO)
	public Contato popularContato(){
		return new Contato();
	}
	
}
