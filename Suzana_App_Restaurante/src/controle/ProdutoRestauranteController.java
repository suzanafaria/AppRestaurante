package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDao;
import dao.RestauranteDao;
import negocio.Restaurante;

public class ProdutoRestauranteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Restaurante restaurante;
    
 
    public ProdutoRestauranteController() {
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		restaurante = RestauranteDao.obterPorId(Integer.valueOf(request.getParameter("id")));
		
		request.setAttribute("restaurante", restaurante);
		request.setAttribute("produtos", ProdutoDao.obterLista());

		request.getRequestDispatcher("associaProduto.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		for(String idProduto : request.getParameterValues("produtos")){
			RestauranteDao.associarProduto(restaurante.getId(), Integer.valueOf(idProduto));
		}
		
		request.setAttribute("restaurantes", RestauranteDao.obterLista());
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

}
