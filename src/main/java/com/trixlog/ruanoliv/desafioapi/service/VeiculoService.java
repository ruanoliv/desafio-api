package com.trixlog.ruanoliv.desafioapi.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trixlog.ruanoliv.desafioapi.model.Veiculo;
import com.trixlog.ruanoliv.desafioapi.model.repository.VeiculoRepository;
import com.trixlog.ruanoliv.desafioapi.rest.veiculo.VeiculoFormRequest;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repository;
	
	public void salvar(Veiculo veiculo) {
		
		repository.save(veiculo);
		
	}
	
	public void atualizar(Veiculo veiculo) {
		
		repository.save(veiculo);
		
	}
	
	public void deletar(Long id) {
		
		repository.deleteById(id);
		
	}
	
	public List<VeiculoFormRequest> listarPorPlaca(String placa){
		return repository.findByPlacaContaining(placa).stream()
		.map(VeiculoFormRequest::fromModel )
		.collect(Collectors.toList());
	}
	
	public List<VeiculoFormRequest> listarPorDatas(Date dataAquisicaoInicial, Date dataAquisicaoFinal){
		return repository.findByDataAquisicaoBetween(dataAquisicaoInicial, dataAquisicaoFinal).stream()
		.map(VeiculoFormRequest::fromModel )
		.collect(Collectors.toList());
	}
	
	public List<VeiculoFormRequest> listarPorUf(String ufEmplacamento){
		return repository.findByUfEmplacamento(ufEmplacamento).stream()
				.map(VeiculoFormRequest::fromModel )
				.collect(Collectors.toList());
	}
	
	public List<VeiculoFormRequest> listarPorNomeCondutor(String nome){
		return repository.findByCondutorContaining(nome).stream()
				.map(VeiculoFormRequest::fromModel )
				.collect(Collectors.toList());
	}
}
