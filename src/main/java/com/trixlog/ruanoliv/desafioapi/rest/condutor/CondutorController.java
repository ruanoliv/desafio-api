package com.trixlog.ruanoliv.desafioapi.rest.condutor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trixlog.ruanoliv.desafioapi.model.Condutor;
import com.trixlog.ruanoliv.desafioapi.model.repository.CondutorRepository;
import com.trixlog.ruanoliv.desafioapi.service.CondutorService;

@RestController
@RequestMapping("/api/condutor")
public class CondutorController {
	
	@Autowired
	private CondutorService condutorService;
	
	@Autowired
	private CondutorRepository repository;
	
	@PostMapping
	public CondutorFormRequest salvar(@RequestBody CondutorFormRequest condutor) {
		
		Condutor entityCondutor = condutor.toModel();
		condutorService.salvar(entityCondutor);
		System.out.println(entityCondutor);
		return CondutorFormRequest.fromModel(entityCondutor);
		
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Void> atualizar(@RequestParam("id") Long id, @RequestBody CondutorFormRequest condutor) {
		Optional<Condutor> condutorExistente = repository.findById(id);
		
		if(condutorExistente .isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Condutor entityCondutor = condutor.toModel();
		entityCondutor.setId(id);
		condutorService.atualizar(entityCondutor);
		
		return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<Void> deletar(@RequestParam("id") Long id){
		Optional<Condutor> condutorExistente = repository.findById(id);
		
		if(condutorExistente .isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		condutorService.deletar(condutorExistente.get().getId());
		return ResponseEntity.noContent().build();
		
	}
}
