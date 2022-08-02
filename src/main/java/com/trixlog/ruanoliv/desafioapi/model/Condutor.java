package com.trixlog.ruanoliv.desafioapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "\"condutor\"")
public class Condutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(name = "numero_cnh")
	private String numeroCnh;
	
	@JsonBackReference
	@OneToMany(mappedBy="condutor")
    private List<Veiculo> veiculos;

	public Condutor() {
		super();
	}

	public Condutor(String nome, String numeroCnh) {
		super();
		this.nome = nome;
		this.numeroCnh = numeroCnh;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroCnh() {
		return numeroCnh;
	}

	public void setNumeroCnh(String numeroCnh) {
		this.numeroCnh = numeroCnh;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	
	
}
