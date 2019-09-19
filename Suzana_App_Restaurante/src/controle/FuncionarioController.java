package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionarioDao;
import negocio.Funcionario;

public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Funcionario> lista;

	public FuncionarioController() {
		super();
		lista = new ArrayList<Funcionario>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.chamarListaFuncionario(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Funcionario funcionario = new Funcionario(
				request.getParameter("nome"),
				request.getParameter("email"),
				request.getParameter("telefone")
				);
		
		FuncionarioDao.incluir(funcionario);
		
		request.setAttribute("mensagem", funcionario.toString());
		request.setAttribute("titulo", "Funcionário");
		request.setAttribute("controller", "FuncionarioController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

	private void chamarListaFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("funcionarios", FuncionarioDao.obterLista());
		request.getRequestDispatcher("funcionarioLista.jsp").forward(request, response);

	}

}
