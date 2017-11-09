package com.eloi.sociotorcedor.domain;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Cliente {
	
	private Long id;
	private String nomeCompleto;
	private String email;
	private LocalDate dataNascimento;
	private Clube timeCoracao;
	
	public Cliente(Long id, String nomeCompleto, String email, LocalDate dataNascimento, Clube timeCoracao) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.timeCoracao = timeCoracao;
	}

	public Cliente() {}

	public Long getId() {
		return id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Clube getTimeCoracao() {
		return timeCoracao;
	}
	
}
