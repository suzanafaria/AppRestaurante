package testes;

import negocio.Bebida;
import negocio.Comida;
import negocio.Funcionario;
import negocio.Restaurante;
import negocio.Sobremesa;

public class RestauranteTeste {

	public static void main(String[] args) {
		
		Funcionario contato = new Funcionario("Suzana", "suzana@infnet.com", "99875-0012");
		
		Comida comida1 = new Comida("#C41", "Caesar Salad", 15.00f);
		comida1.setTipo("Prato Principal (saladas)");
		comida1.setAcompanhamentoExtra(false);	
		comida1.setServeDuasPessoas(false);

		Comida comida2 = new Comida("#C20", "Risoto de Pato", 40.00f);
		comida2.setTipo("Prato Principal (risotos)");
		comida2.setAcompanhamentoExtra(true);	
		comida2.setServeDuasPessoas(false);

		Bebida bebida1 = new Bebida("#B103", "Refrigerante", 5.00f);
		bebida1.setMarca("Coca-Cola");
		bebida1.setTamanho("350ml");
		bebida1.setAlcoolica(false);
		
		Bebida bebida2 = new Bebida("#B104", "Vinho", 5.50f);
		bebida2.setMarca("Santa Helena Tinto");
		bebida2.setTamanho("taça");
		bebida2.setAlcoolica(true);
		
		Sobremesa sobremesa1 = new Sobremesa("#S10", "Sorvete de Pistache", 10.15f);
		sobremesa1.setSobremesaFria(true);
		sobremesa1.setContemLactose(true);
		sobremesa1.setVersaoDiet(true);
				
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setCategoria("Japones");
		restaurante1.setNome("Japamaki");
		restaurante1.setLocalizacaoBairro("Gávea");
		restaurante1.associa(contato);
		
		restaurante1.adiciona(comida1);
		restaurante1.adiciona(comida2);
		restaurante1.adiciona(bebida1);
		restaurante1.adiciona(bebida2);
		restaurante1.adiciona(sobremesa1);
		
		restaurante1.exibir();
		

	}
	
}
