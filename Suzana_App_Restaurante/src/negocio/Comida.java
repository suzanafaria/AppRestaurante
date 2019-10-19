package negocio;
import modelo.Produto;

public class Comida extends Produto {
	private String tipo; 	// entrada, prato principal (carnes, saladas, peixes, massas, etc...)
	private boolean serveDuasPessoas;
	private boolean acompanhamentoExtra;

	
	
	public Comida(String codigo, String nome, float preco) {
		super(codigo, nome, preco);	
	}
	
	public Comida(int id, String codigo, String nome, float preco, String tipo, boolean serveDuasPessoas, boolean acompanhamentoExtra) {
		super(id, codigo, nome, preco);
		this.setTipo(tipo);
		this.setServeDuasPessoas(serveDuasPessoas);
		this.setAcompanhamentoExtra(acompanhamentoExtra);	
	}
	
	public Comida(String codigo, String nome, float preco, String tipo, boolean serveDuasPessoas, boolean acompanhamentoExtra) {
		this(codigo, nome, preco);
		this.setTipo(tipo);
		this.setServeDuasPessoas(serveDuasPessoas);
		this.setAcompanhamentoExtra(acompanhamentoExtra);	
	}
	
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return this.tipo;
	}	
	public boolean isServeDuasPessoas() {
		return serveDuasPessoas;
	}
	public void setServeDuasPessoas(boolean serveDuasPessoas) {
		this.serveDuasPessoas = serveDuasPessoas;
	}
	public boolean isAcompanhamentoExtra() {
		return acompanhamentoExtra;
	}
	public void setAcompanhamentoExtra(boolean acompanhamentoExtra) {
		this.acompanhamentoExtra = acompanhamentoExtra;
	}
	
	public void exibir() {
		super.exibir();	// imprime o método exibir da classe mãe
		System.out.println("Prato escolhido:");
		System.out.println(this);
	}
	
	public String toString() {
		return String.format("%s;%s;%s;%s", 
				super.toString(),
				this.tipo,
				acompanhamentoExtra ? "Tem acompanhamento extra" : "Não tem acompanhamento extra",
				this.serveDuasPessoas ? "Sim" : "Não");
	}
	
}
