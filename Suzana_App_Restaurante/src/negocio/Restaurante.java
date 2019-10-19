package negocio;

import java.util.Set;

import auxiliar.Constante;
import modelo.Produto;

public class Restaurante {
	
	private int id;
	private String nome;
	private String categoria;
	private String localizacaoBairro;
	private Gerente gerente;
	private Set<Produto> produtos;
	private int[] qtdeProdutos;
	
	
	public Restaurante(String nome, String categoria, String localizacaoBairro) {
		this.nome = nome;
		this.categoria = categoria;
		this.localizacaoBairro = localizacaoBairro;
	}
	
	
	public Restaurante(int id, String nome, String categoria, String localizacaoBairro) {
		this(nome, categoria, localizacaoBairro);
		this.id = id;
	}


	public Restaurante(int id, String nome, String categoria, String localizacaoBairro, Gerente gerente,
			Set<Produto> produtos) {
		this(id, nome, categoria, localizacaoBairro);
		this.gerente= gerente;
		this.setProdutos(produtos);
		this.setId(id);
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
	public Set<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	public void exibir() {
		if (this.validar()) {
			qtdeProdutos = new int[Constante.PRODUTOS.length];
			System.out.println("Dados Restaurante: \n" + this);
			System.out.println("Dados Funcionario: \n" + this.gerente);		

			
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
		return String.format("%s - %s - %s;\nGerente: %s", 
				this.nome, 
				this.categoria,
				this.localizacaoBairro,
				this.getGerente());
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

	public void associa(Gerente gerente) {
		this.gerente = gerente;
	}
	
	public void adiciona(Produto produto) {
		this.getProdutos().add(produto);
	}


	

	
}
