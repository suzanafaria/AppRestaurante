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

	private Comida comida;
	
    public ComidaController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("comidas", ComidaDao.obterLista());
		request.getRequestDispatcher("comidaLista.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		comida = (Comida) request.getSession().getAttribute("newComida");
		comida.setTipo(request.getParameter("tipo"));
		comida.setServeDuasPessoas(Boolean.valueOf(request.getParameter("serveDuasPessoas")));
		comida.setAcompanhamentoExtra(Boolean.valueOf(request.getParameter("acompanhamentoExtra")));
		
		ComidaDao.incluir(comida);
		
		request.setAttribute("mensagem", comida.toString());
		request.setAttribute("titulo", "Comida");
		request.setAttribute("controller", "ComidaController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
