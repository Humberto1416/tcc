package com.tcc.inf2cm.motofast.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    
    private String nome;
    private String telefone;
    private String senha;
	private String cpf;
    private String setor;
    private String email;
   
	private boolean status = true;
	
	
	
	public boolean isStatus() {
		return status;
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
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	 public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getSetor() {
			return setor;
		}
		public void setSetor(String setor) {
			this.setor = setor;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	
}
	

