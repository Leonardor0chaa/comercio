package com.itb.tcc.busmap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="linha")
public class Linha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String empresa;
	private String nomeIda;
	private String nomeVolta;
	private String tarifas;
	private boolean codStatusLinha;
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
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getNomeIda() {
		return nomeIda;
	}
	public void setNomeIda(String nomeIda) {
		this.nomeIda = nomeIda;
	}
	public String getNomeVolta() {
		return nomeVolta;
	}
	public void setNomeVolta(String nomeVolta) {
		this.nomeVolta = nomeVolta;
	}
	public String getTarifas() {
		return tarifas;
	}
	public void setTarifas(String tarifas) {
		this.tarifas = tarifas;
	}
	public boolean isCodStatusLinha() {
		return codStatusLinha;
	}
	public void setCodStatusLinha(boolean codStatusLinha) {
		this.codStatusLinha = codStatusLinha;
	}
	
	

	
}