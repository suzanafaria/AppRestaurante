package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SobremesaDao;
import negocio.Sobremesa;

public class SobremesaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Sobremesa sobremesa;
	
    public SobremesaController() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("sobremesas", SobremesaDao.obterLista());
		request.getRequestDispatcher("sobremesaLista.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		sobremesa = (Sobremesa)request.getSession().getAttribute("newSobremesa");
		
		sobremesa.setSobremesaFria(Boolean.valueOf(request.getParameter("sobremesaFria")));
		sobremesa.setVersaoDiet(Boolean.valueOf(request.getParameter("versaoDiet")));
		sobremesa.setContemLactose(Boolean.valueOf(request.getParameter("contemLactose")));
		
		SobremesaDao.incluir(sobremesa);
		
		request.setAttribute("mensagem", sobremesa.toString());
		request.setAttribute("titulo", "Sobremesa");
		request.setAttribute("controller", "SobremesaController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
