package com.ufc.demo.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.ufc.demo.model.Contato;

@org.springframework.stereotype.Repository
public interface ContatoRepository extends Repository<Contato, Long> {
	
	void save(Contato contato);
	
	void delete(Contato contato);
	
	List<Contato> findAll();
	
	List<Contato> findById(Long id);
	
}
