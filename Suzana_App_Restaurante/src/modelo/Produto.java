package modelo;

import java.util.Locale;

import negocio.Bebida;
import negocio.Comida;

public abstract class Produto {
	private int id;
	private String codigo;
	private String nome;	//refrigerante, agua, vinho, 
	private float preco;
	static int qtdeProdutos;		//variavel vista pelas filhas para quantificar os objetos do tipo Refeicao criados no projeto.
	
	public Produto() {};
	
	public Produto(int id) {
		this.id=id;
	}
	
	public Produto(int id, String codigo, String nome, float preco) {
		this(codigo, nome, preco);
		this.id=id;
	}
	
	public Produto(String codigo, String nome, float preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		
		qtdeProdutos++;	
		/* todas as filhas passam por essa linha de codigo porque é obrigatoria a chamada deste construtor 
		   na criação das Classes Filhas. Controle interno para saber a quantidade de objetos que foram passados.*/
							
		//System.out.println("Qtde: " + qtdeRefeicoes);
	}
	
	
	public String obterTipo() {
		if(this instanceof Bebida) {
			return "Bebida";
		} else if (this instanceof Comida){
			return "Comida";
		} else {
			return "Sobremesa";
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public static int getQtdeProdutos() {
		return qtdeProdutos;
	}
	public static void setQtdeProdutos(int qtdeProdutos) {
		Produto.qtdeProdutos = qtdeProdutos;
	}


	@Override
	public String toString() {	//preco é digitado com ponto (ex.: 3.50) e o Locale.US converte o . para ,
		return String.format(Locale.US, "%s;%s;%.2f", 
				this.codigo, 
				this.nome,
				this.preco);
	}
	
	
	public void exibir() {
		System.out.println("Produto: ");
	}
	
	public static int obterQtdeProdutos() {
		return qtdeProdutos;
	}

	
}
