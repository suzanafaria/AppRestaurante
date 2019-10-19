package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GerenteDao;
import dao.RestauranteDao;
import negocio.Gerente;
import negocio.Restaurante;

public class GerenteRestauranteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Restaurante restaurante;
	
    public GerenteRestauranteController() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		restaurante = RestauranteDao.obterPorId(Integer.valueOf(request.getParameter("id")));
		
		request.setAttribute("restaurante", restaurante);
		request.setAttribute("gerentes", GerenteDao.obterLista());

		request.getRequestDispatcher("gerenteRestaurante.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		restaurante.setGerente(new Gerente(Integer.valueOf(request.getParameter("idGerente"))));
		
		RestauranteDao.associarGerente(restaurante);
		
		request.setAttribute("restaurantes", RestauranteDao.obterLista());
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

}
