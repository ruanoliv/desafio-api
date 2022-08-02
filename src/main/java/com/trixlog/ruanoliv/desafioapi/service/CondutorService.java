package com.trixlog.ruanoliv.desafioapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trixlog.ruanoliv.desafioapi.model.Condutor;
import com.trixlog.ruanoliv.desafioapi.model.repository.CondutorRepository;

@Service
public class CondutorService {
	
	@Autowired
	private CondutorRepository repository;
	
	public void salvar(Condutor condutor) {
		
		repository.save(condutor);
		
	}
	
	public void atualizar(Condutor condutor) {
		
		repository.save(condutor);
		
	}
	
	public void deletar(Long id) {
		
		repository.deleteById(id);
		
	}
	
}
