package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestauranteDao;
import negocio.Restaurante;

public class ConsultaRestauranteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Restaurante restaurante;   
	
    public ConsultaRestauranteController() {
    	super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		restaurante = RestauranteDao.obterPorId(Integer.valueOf(request.getParameter("id")));
		
		request.setAttribute("restaurante", restaurante);
		request.getRequestDispatcher("restauranteConsulta.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
