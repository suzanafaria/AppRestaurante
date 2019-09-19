package testes;

import dao.FuncionarioDao;
import negocio.Funcionario;

public class FuncionarioTeste {

	public static void main(String[] args) {
		
//		Funcionario contato = new Funcionario("Suzana", "suzana@infnet.com", "99875-0012");
//				
//		contato.exibir();
		
		for (Funcionario item : FuncionarioDao.obterLista()) {
			System.out.println(item);
		}
		

	}

}
