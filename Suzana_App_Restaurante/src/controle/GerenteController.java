package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GerenteDao;
import negocio.Gerente;

public class GerenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GerenteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("idGerente") != null) {
			GerenteDao.excluir(Integer.valueOf(request.getParameter("idGerente")));
			request.setAttribute("gerentes", GerenteDao.obterLista());
			request.getRequestDispatcher("gerenteoLista.jsp").forward(request, response);
			
		}else {
			if(request.getParameter("operacao") != null) {
				request.getRequestDispatcher("gerenteCadastro.jsp").forward(request, response);
			} else {	
				request.setAttribute("gerentes", GerenteDao.obterLista());
				request.getRequestDispatcher("gerenteLista.jsp").forward(request, response);
			}
		}
			
		}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gerente gerente = new Gerente(
				request.getParameter("nome"),
				request.getParameter("email"),
				request.getParameter("telefone")
				);
		
		GerenteDao.incluir(gerente);
		
		request.setAttribute("mensagem", "Cadastro realizado com sucesso "+gerente.toString());
		request.setAttribute("titulo", "Gerente");
		request.setAttribute("controller", "GerenteController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

	
}

