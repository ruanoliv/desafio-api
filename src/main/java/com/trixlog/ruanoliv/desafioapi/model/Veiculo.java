package com.trixlog.ruanoliv.desafioapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String placa;
	private String chassi;
	private String renavan;
	
	@Column(name = "ano_modelo")
	private String anoModelo;
	
	@Column(name = "ano_fabricacao")
	private String anoFabricacao;
	private String cor;
	
	@Column(name = "uf_emplacamento")
	private String ufEmplacamento;
	
	@Column(name = "data_aquisicao")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dataAquisicao;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "condutor_id", nullable=false)
	private Condutor condutor;
	
	public Veiculo() {
		super();
	}
	
	
	public Veiculo(Long id, String placa, String chassi, String renavan, String anoModelo, String anoFabricacao,
			String cor, String ufEmplacamento, Date dataAquisicao, Condutor condutor) {
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
