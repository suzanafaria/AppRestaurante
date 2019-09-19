package negocio;
import modelo.Produto;

public class Bebida extends Produto {
	private String marca;
	private String tamanho;
	private boolean alcoolica;

	public Bebida() {
		super();
	};
	
	public Bebida(String codigo, String nome, float preco) {
		super(codigo, nome, preco);
	}
	
	public Bebida(int id, String codigo, String nome, float preco, String marca, String tamanho, boolean alcoolica) {
		super(id, codigo, nome, preco);
		this.setMarca(marca);
		this.setTamanho(tamanho);
		this.setAlcoolica(alcoolica);
			
	}
	


	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public boolean isAlcoolica() {
		return alcoolica;
	}
	public void setAlcoolica(boolean alcoolica) {
		this.alcoolica = alcoolica;
	}
	
	
	public void exibir() {
		super.exibir();
		System.out.println("Bebida: ");
		System.out.println(this);		
	}
	
	@Override
	public String toString() {
		return String.format("%s;%s;%s;%s", 
				super.toString(),
				this.marca,
				this.tamanho,
				alcoolica ? "Bebida alcoolica" : "Bebida não-alcoolica");
	}
}
