package com.trixlog.ruanoliv.desafioapi.rest.veiculo;

import java.util.Date;
import com.trixlog.ruanoliv.desafioapi.model.Condutor;
import com.trixlog.ruanoliv.desafioapi.model.Veiculo;

public class VeiculoFormRequest {
	
	private Long id;
	private String placa;
	private String chassi;
	private String renavan;
	private String anoModelo;
	private String anoFabricacao;
	private String cor;
	private String ufEmplacamento;
	private Date dataAquisicao;
	private Condutor condutor;
	
	public VeiculoFormRequest() {
		super();
	}

	public VeiculoFormRequest(Long id, String placa, String chassi, String renavan, String anoModelo,
			String anoFabricacao, String cor, String ufEmplacamento, Date dataAquisicao, Condutor condutor) {
		super();
		this.id = id;
		this.placa = placa;
		this.chassi = chassi;
		this.renavan = renavan;
		this.anoModelo = anoModelo;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
		this.ufEmplacamento = ufEmplacamento;
		this.dataAquisicao = dataAquisicao;
		this.condutor = condutor;
	}
	
	public Veiculo toModel() {
		return new Veiculo(
				id,
				placa,
				chassi,
				renavan,
				anoModelo,
				anoFabricacao,
				cor,
				ufEmplacamento,
				dataAquisicao, 
				condutor);
	}
	
	public static VeiculoFormRequest fromModel(Veiculo veiculo) {
		return new VeiculoFormRequest(
					veiculo.getId(),
					veiculo.getPlaca(),
					veiculo.getChassi(),
					veiculo.getRenavan(),
					veiculo.getAnoModelo(),
					veiculo.getAnoFabricacao(),
					veiculo.getCor(),
					veiculo.getUfEmplacamento(),
					veiculo.getDataAquisicao(),
					veiculo.getCondutor()
				);
				
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getRenavan() {
		return renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}

	
	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getUfEmplacamento() {
		return ufEmplacamento;
	}

	public void setUfEmplacamento(String ufEmplacamento) {
		this.ufEmplacamento = ufEmplacamento;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
	
	
	
	
}
