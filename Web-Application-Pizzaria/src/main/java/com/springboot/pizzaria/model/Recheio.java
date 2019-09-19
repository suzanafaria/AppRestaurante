package com.springboot.pizzaria.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Recheio {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String tipo;
	private float valor;
	@OneToOne 
	private Pizza pizza;
	
	public Recheio() {
		
	}
	
	public Recheio(String tipo, float valor, Pizza pizza) {
		this.tipo = tipo;
		this.valor = valor;
		this.pizza = pizza;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}


}