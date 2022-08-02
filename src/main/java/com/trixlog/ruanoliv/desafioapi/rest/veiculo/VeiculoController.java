package com.trixlog.ruanoliv.desafioapi.rest.veiculo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trixlog.ruanoliv.desafioapi.model.Veiculo;
import com.trixlog.ruanoliv.desafioapi.model.repository.VeiculoRepository;
import com.trixlog.ruanoliv.desafioapi.service.VeiculoService;


@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private VeiculoRepository repository;
	
	@PostMapping
	public VeiculoFormRequest salvar(@RequestBody VeiculoFormRequest veiculo) {
		
		Veiculo entityVeiculo = veiculo.toModel();
		veiculoService.salvar(entityVeiculo);
		System.out.println(entityVeiculo);
		return VeiculoFormRequest.fromModel(entityVeiculo);
		
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Void> atualizar(@RequestParam("id") Long id, @RequestBody VeiculoFormRequest veiculo) {
		Optional<Veiculo> veiculoExistente = repository.findById(id);
		
		if(veiculoExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Veiculo entityVeiculo = veiculo.toModel();
		entityVeiculo.setId(id);
		veiculoService.atualizar(entityVeiculo);
		
		return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<Void> deletar(@RequestParam("id") Long id){
		Optional<Veiculo> veiculoExistente = repository.findById(id);
		
		if(veiculoExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		veiculoService.deletar(veiculoExistente.get().getId());
		return ResponseEntity.noContent().build();
		
	}
	@GetMapping("listarPlaca")
	public List<VeiculoFormRequest> getListaByPlaca(@RequestParam("placa") String placa){
		return veiculoService.listarPorPlaca(placa);
	}
	@GetMapping("listarEntreDatas")
	public List<VeiculoFormRequest> getListaBetweenDates(@DateTimeFormat(pattern="ddMMyyyy") @RequestParam ("dataAquisicaoInicial") Date dataAquisicaoInicial,@DateTimeFormat(pattern="ddMMyyyy") @RequestParam ("dataAquisicaoFinal")  Date dataAquisicaoFinal){
		return veiculoService.listarPorDatas(dataAquisicaoInicial, dataAquisicaoFinal);
	}
	@GetMapping("listarUf")
	public List<VeiculoFormRequest> getListaByUf(@RequestParam ("ufEmplacamento") String ufEmplacamento){
		return veiculoService.listarPorUf(ufEmplacamento);
	}
	@GetMapping("listarNomeCondutor")
	public List<VeiculoFormRequest> getListaNomeCondutor(@RequestParam ("nome") String nomeCondutor){
		return veiculoService.listarPorNomeCondutor(nomeCondutor);
	}
	
}	
