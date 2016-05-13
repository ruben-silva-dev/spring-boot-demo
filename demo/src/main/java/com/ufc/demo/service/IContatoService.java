package com.ufc.demo.service;

import java.util.List;

import com.ufc.demo.model.Contato;

public interface IContatoService {
	
	public List<Contato> getContatos();
	
	public void salvar(Contato contato);
	
	public void apagar(Contato contato);
}
