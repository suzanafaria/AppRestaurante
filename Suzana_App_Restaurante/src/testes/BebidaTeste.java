package testes;

import negocio.Bebida;

public class BebidaTeste {

	public static void main(String[] args) {
		
		Bebida bebida = new Bebida("66", "Coca-Cola", 5.50f);
		bebida.setTamanho("350ml");
		bebida.setAlcoolica(false);
		
		
		
		bebida.exibir();
	}

}
