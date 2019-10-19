package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestauranteDao;
import negocio.Restaurante;


public class RestauranteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RestauranteController() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("operacao") != null) {
			request.getRequestDispatcher("restauranteCadastro.jsp").forward(request, response);
		} else {	
			request.setAttribute("restaurantes", RestauranteDao.obterLista());
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Restaurante restaurante = new Restaurante(
				request.getParameter("nome"),
				request.getParameter("categoria"),
				request.getParameter("localizacaoBairro")
				);
		
		RestauranteDao.incluir(restaurante);
		
		request.setAttribute("mensagem", "Cadastro realizado com sucesso "+restaurante.toString());
		request.setAttribute("titulo", "Restaurante");
		request.setAttribute("controller", "RestauranteController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}
}
