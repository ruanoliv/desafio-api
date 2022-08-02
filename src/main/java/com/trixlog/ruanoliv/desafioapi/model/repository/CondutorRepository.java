package com.trixlog.ruanoliv.desafioapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trixlog.ruanoliv.desafioapi.model.Condutor;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {
	
}
