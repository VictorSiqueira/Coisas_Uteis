package com.application.model;

import java.util.Date;

public class ObjTeste {
	private Integer id;
	private String nome;
	private Date data;
	private String status;
	
	public ObjTeste(Integer id, String nome, Date data, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.status = status;
	}
	
	public ObjTeste() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
