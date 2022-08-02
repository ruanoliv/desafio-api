package com.trixlog.ruanoliv.desafioapi.rest.condutor;

import com.trixlog.ruanoliv.desafioapi.model.Condutor;

public class CondutorFormRequest {
	
	private Long id;
	private String nome;
	private String numeroCnh;

	public CondutorFormRequest() {
		super();
	}
	public CondutorFormRequest(Long id, String nome, String numeroCnh) {
		super();
		this.id = id;
		this.nome = nome;
		this.numeroCnh = numeroCnh;
	}
	
	public Condutor toModel() {
		return new Condutor(nome, numeroCnh);
	}
	
	public static CondutorFormRequest fromModel(Condutor condutor) {
		return new CondutorFormRequest(
				condutor.getId(), 
				condutor.getNome(), 
				condutor.getNumeroCnh()
				);
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
}
