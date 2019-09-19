package com.springboot.pizzaria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Produto {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String nome;
	private float preco;
	@ManyToMany 
	private Set<Pedido> pedidos;
	
	public Produto() {}
	
	public Produto(String nome, float preco) {
		this.nome = nome;
		this.preco = preco;
	}
	public Produto(String nome) {
		this.nome = nome;		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return String.format("%s", 
				this.nome);
				//this.preco
	}
}

