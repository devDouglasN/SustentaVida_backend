package com.douglas.nutrisimples.domain;

public class User {

	private Long id;
	private String nome;
	private String usuarioEmail;
	private String senha;
	
	public User() {
	}

	public User(Long id, String nome, String usuarioEmail, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuarioEmail = usuarioEmail;
		this.senha = senha;
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

	public String getUsuarioEmail() {
		return usuarioEmail;
	}

	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
