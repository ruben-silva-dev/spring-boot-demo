package com.ufc.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.demo.model.Contato;
import com.ufc.demo.repository.ContatoRepository;
import com.ufc.demo.service.IContatoService;

@Service
public class ContatoService implements IContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Override
	public List<Contato> getContatos() {
		return contatoRepository.findAll();
	}

	@Override
	public void salvar(Contato contato) {
		contatoRepository.save(contato);
	}

	@Override
	public void apagar(Contato contato) {
		contatoRepository.delete(contato);
	}

}
