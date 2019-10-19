package negocio;

import modelo.Produto;

public class Sobremesa extends Produto{

	private boolean sobremesaFria;
	private boolean versaoDiet;
	private boolean contemLactose;
	

	

	public Sobremesa(String codigo, String nome, float preco) {
		super(codigo, nome, preco);
	}
	
	public Sobremesa(int id, String codigo, String nome, float preco, boolean sobremesaFria, boolean versaoDiet, boolean contemLactose) {
		super(id, codigo, nome, preco);
		this.setSobremesaFria(sobremesaFria);
		this.setVersaoDiet(versaoDiet);
		this.setContemLactose(contemLactose);	
	}
	

	public Sobremesa(String codigo, String nome, float preco, boolean sobremesaFria, boolean versaoDiet, boolean contemLactose) {
		this(codigo, nome, preco);
		this.setSobremesaFria(sobremesaFria);
		this.setVersaoDiet(versaoDiet);
		this.setContemLactose(contemLactose);
	}
	

	public boolean isSobremesaFria() {
		return sobremesaFria;
	}
	public void setSobremesaFria(boolean sobremesaFria) {
		this.sobremesaFria = sobremesaFria;
	}
	public boolean isVersaoDiet() {
		return versaoDiet;
	}
	public void setVersaoDiet(boolean versaoDiet) {
		this.versaoDiet = versaoDiet;
	}
	public boolean isContemLactose() {
		return contemLactose;
	}
	public void setContemLactose(boolean contemLactose) {
		this.contemLactose = contemLactose;
	}
	

	public void exibir() {
		super.exibir();
		System.out.println("Sobremesa: ");
		System.out.println(this);		
	}	
	@Override
	public String toString() {
		return String.format("%s;%s;%s;%s", 
				super.toString(),
				this.sobremesaFria ? "Sobremesa Fria" : "Sobremesa Quente",
				this.versaoDiet ? "Versão Diet" : "Não é Diet",
				this.contemLactose ? "Contém Lactose" : "Não contem Lactose");
	}

}
