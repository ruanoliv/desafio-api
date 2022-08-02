package com.trixlog.ruanoliv.desafioapi.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trixlog.ruanoliv.desafioapi.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	List<Veiculo> findByPlacaContaining(String placa);
	
	List<Veiculo> findByDataAquisicaoBetween(Date dataAquisicaoInicial, Date dataAquisicaoFinal);
	
	List<Veiculo> findByUfEmplacamento(String ufEmplacamento);
	
	@Query(value = "SELECT * FROM veiculo v INNER JOIN condutor ON condutor.id = v.condutor_id WHERE condutor.nome LIKE ?1%", nativeQuery = true)
	List<Veiculo> findByCondutorContaining(String nome);
	
}
