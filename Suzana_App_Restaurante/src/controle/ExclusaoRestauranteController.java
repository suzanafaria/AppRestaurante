package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestauranteDao;


public class ExclusaoRestauranteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExclusaoRestauranteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("restaurantes", RestauranteDao.obterLista());
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RestauranteDao.excluir(Integer.valueOf(request.getParameter("id")));
		
		request.setAttribute("mensagem", "Restaurante excluido com sucesso!");
		request.setAttribute("titulo", "Restaurante");
		request.setAttribute("controller", "ExclusaoRestauranteController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
