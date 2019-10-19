package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComidaDao;
import negocio.Comida;

public class ComidaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ComidaController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idProduto") != null) {
			ComidaDao.excluir(Integer.valueOf(request.getParameter("idProduto")));
			request.setAttribute("comidas", ComidaDao.obterLista());
			request.getRequestDispatcher("comidaLista.jsp").forward(request, response);
		}else {		
			if(request.getParameter("operacao") != null) {
				request.getRequestDispatcher("comidaCadastro.jsp").forward(request, response);
			} else {	
				request.setAttribute("comidas", ComidaDao.obterLista());
				request.getRequestDispatcher("comidaLista.jsp").forward(request, response);
			}
		}
	}
		
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Comida comida = new Comida(
				request.getParameter("codigo"),
				request.getParameter("nome"),
				Float.valueOf(request.getParameter("preco")),
				request.getParameter("tipo"),
				Boolean.valueOf(request.getParameter("serveDuasPessoas")),
				Boolean.valueOf(request.getParameter("acompanhamentoExtra")));

		
		ComidaDao.incluir(comida);
		
		request.setAttribute("mensagem", "Cadastro realizado com sucesso "+comida.toString());
		request.setAttribute("titulo", "Comida");
		request.setAttribute("controller", "ComidaController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
