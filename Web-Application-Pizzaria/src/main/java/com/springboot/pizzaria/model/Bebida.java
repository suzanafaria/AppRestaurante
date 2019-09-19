package com.springboot.pizzaria.model;

import javax.persistence.Entity;

@Entity
public class Bebida extends Produto{

	public Bebida() {
		super();
	}
	public Bebida(String nome, float preco) {
		super(nome, preco);
	}

}
