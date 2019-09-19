package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BebidaDao;
import negocio.Bebida;

public class BebidaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Bebida bebida;
	
    public BebidaController() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bebidas", BebidaDao.obterLista());
		request.getRequestDispatcher("bebidaLista.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		bebida = (Bebida)request.getSession().getAttribute("newBebida");
		
		bebida.setMarca(request.getParameter("marca"));
		bebida.setTamanho(request.getParameter("tamanho"));
		bebida.setAlcoolica(Boolean.valueOf(request.getParameter("alcoolica")));	
	
		BebidaDao.incluir(bebida);
		
		request.setAttribute("mensagem", bebida.toString());
		request.setAttribute("titulo", "Bebida");
		request.setAttribute("controller", "BebidaController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);

	}

}
