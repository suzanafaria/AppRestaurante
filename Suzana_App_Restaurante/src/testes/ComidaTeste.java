package testes;

import negocio.Comida;

public class ComidaTeste {

	public static void main(String[] args) {
		
		Comida comida = new Comida("254", "Arroz à Piamontese", 25.45f);
		comida.setAcompanhamentoExtra(false);	//qual acompanhamento extra? fazer um switch case com if
		comida.setServeDuasPessoas(false);
		
		comida.exibir();
		
	}

}
