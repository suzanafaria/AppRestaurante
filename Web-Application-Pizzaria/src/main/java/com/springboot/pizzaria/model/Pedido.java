package com.springboot.pizzaria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String numero;
	private float valorTotal;
	private String formaPagamento;
	
	@JsonIgnore
	@OneToOne
	private Cliente cliente;
	@ManyToMany (mappedBy = "pedidos")
	private Set<Produto> produtos;
	
	public Pedido() {}
	
	public Pedido(String numero, Cliente cliente, Set<Produto> produtos, String formaPagamento) {
		this.numero = numero;
		this.cliente = cliente;
		this.produtos = produtos;
		this.formaPagamento = formaPagamento;
		
		//this.fecharConta();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getValorTotal() {
		return this.valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Set<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
//	
//	
//	//calcularPrecoFinal
//	private float calcularPrecoFinal() {
//	float precoPedido = 0;
//	for(Produto item : this.pedidoEscolhido) {
//		precoPedido += item.getPreco();
//	}		
//	return precoPedido;
//	}
//	
//	private float aplicarDesconto(){
//		float precoFinal = calcularPrecoFinal();
//		if(this.pagamento.getFormaPagamento().equals("D�bito")) {
//			precoFinal -= (0.15f * calcularPrecoFinal());
//		} else {
//			precoFinal = calcularPrecoFinal();
//		}
//		return precoFinal;	
//	}	
//	
//	private float fecharConta(){
//        this.valorTotal = this.aplicarDesconto();
//        return Math.round(this.valorTotal);
//    }    
//	
}
