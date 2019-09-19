package negocio;

import java.util.ArrayList;

import auxiliar.Constante;
import modelo.Produto;

public class Restaurante {
	private String nome;
	private String categoria;
	private String localizacaoBairro;
	private Funcionario funcionario;
	private ArrayList<Produto> produtos;
	private int[] qtdeProdutos;
	
	public Restaurante() {
		produtos = new ArrayList<Produto>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getLocalizacaoBairro() {
		return localizacaoBairro;
	}
	public void setLocalizacaoBairro(String localizacaoBairro) {
		this.localizacaoBairro = localizacaoBairro;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public void exibir() {
		if (this.validar()) {
			qtdeProdutos = new int[Constante.PRODUTOS.length];
			System.out.println("Dados Restaurante: \n" + this);
			System.out.println("Dados Funcionario: \n" + this.funcionario);		
//			System.out.println("Dados Refeicao:");
			for(Produto item: this.produtos) {
				item.toString();
				System.out.println(item);
			}
			for(Produto p : this.produtos) {
				this.contabiliza(p);
				
				p.exibir();
			}
			this.showContabiliza();
			
		}	else {
			System.err.println("Inválido");
			}
		}
		
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", 
				this.nome, 
				this.categoria,
				this.localizacaoBairro);
	}
	
	
	
	private boolean validar() {
		return this.getProdutos().size() == Produto.getQtdeProdutos();
	}

	private void contabiliza(Produto produto) {
		if(produto instanceof Comida) {
			this.qtdeProdutos[0]++;
		}else if (produto instanceof Bebida) {
			this.qtdeProdutos[1]++;
		}else if (produto instanceof Sobremesa) {
			this.qtdeProdutos[2]++;
		}
	}
	
	private void showContabiliza() {
		System.out.println("Contabiliza: ");
		for (int i = 0; i < qtdeProdutos.length; i++) {
			System.err.println("- " + 
					Constante.PRODUTOS[i] + ": " + 
					this.qtdeProdutos[i]);
		}
	}

	public void associa(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void adiciona(Produto refeicao) {
		this.getProdutos().add(refeicao);
	}

	
	
//	public void fazerReserva(){
//		//contactar o Responsavel pelo restaurante
//	}	
//	public void montarRefeicao(){ 
//		// comida + bebida
//	}
	
}
