package com.springboot.pizzaria.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Pizza extends Produto{
	
	private String tamanho;
	private boolean bordaRecheada;
	@OneToOne (mappedBy = "pizza", cascade = {CascadeType.ALL}, orphanRemoval = true)
	private Recheio recheio;
	@OneToOne (mappedBy = "pizza", cascade = {CascadeType.ALL}, orphanRemoval = true)
	private Massa massa;
	
	
	public Pizza() {
		super();
	}
	
	public Pizza(String nome, String tamanho, Massa massa, Recheio recheio, boolean bordaRecheada) {
		super(nome);
		this.tamanho = tamanho;
		this.massa = massa;
		this.recheio = recheio;
		this.bordaRecheada = bordaRecheada; 
				
		//this.getPrecoTotal();
		
	}
	
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public boolean isBordaRecheada() {
		return bordaRecheada;
	}
	public void setBordaRecheada(boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}
	public Recheio getRecheio() {
		return recheio;
	}
	public void setRecheio(Recheio recheio) {
		this.recheio = recheio;
		recheio.setPizza(this);
	}
	public Massa getMassa() {
		return massa;
	}
	public void setMassa(Massa massa) {
		this.massa = massa;
		massa.setPizza(this);

	}
//	
//	
//	private float precoSimples() {
//		return this.massa.getValor() + this.recheio.getValor();
//	}
//	
////	private float addBordaRecheada() {
////		return bordaRecheada ? 2.50f : 0.0f;
////	}
//		
//	private float calcularPrecoTamanho() {
//		float precoTamanho = precoSimples();
//		if (this.tamanho.equals("30cm")) {
//			precoTamanho *= 2;
//		}	else if(this.tamanho.equals("15cm") && this.bordaRecheada == true) {
//			precoTamanho += 10.00f; 
//		} else {
//			precoTamanho = precoSimples();
//		}
//		return precoTamanho;
//	}
//	
//	
//	//preco com os adicionais de tamanho e borda recheada
//	private float precoTotal(){
//        super.setPreco(this.calcularPrecoTamanho());
//        return super.getPreco();
//    }
//    
//	
//    public float getPrecoTotal(){
//        return precoTotal();
//    }      
//	
//       
//    
//    @Override
//    public String toString() {
//    	return String.format("%s - %s - Massa %s de %s - %s borda recheada",
//    			super.toString(),
//    			this.tamanho,
//    			this.massa,
//    			this.recheio,
//    			this.bordaRecheada ? "com" : "sem");
//    }
//    
//    public void imprimir() {
//    	System.out.println(this.toString());
//    }
}
