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

    public SobremesaController() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idProduto") != null) {
			SobremesaDao.excluir(Integer.valueOf(request.getParameter("idProduto")));
			request.setAttribute("sobremesas", SobremesaDao.obterLista());
			request.getRequestDispatcher("sobremesaLista.jsp").forward(request, response);
			
		}else {		
		if(request.getParameter("operacao") != null) {
				request.getRequestDispatcher("sobremesaCadastro.jsp").forward(request, response);
			} else {	
				request.setAttribute("sobremesas", SobremesaDao.obterLista());
				request.getRequestDispatcher("sobremesaLista.jsp").forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Sobremesa sobremesa = new Sobremesa(
				request.getParameter("codigo"),
				request.getParameter("nome"),
				Float.valueOf(request.getParameter("preco")),		
				Boolean.valueOf(request.getParameter("sobremesaFria")),
				Boolean.valueOf(request.getParameter("versaoDiet")),
				Boolean.valueOf(request.getParameter("contemLactose")));
		
		SobremesaDao.incluir(sobremesa);
		
		request.setAttribute("mensagem", "Cadastro realizado com sucesso "+sobremesa.toString());
		request.setAttribute("titulo", "Sobremesa");
		request.setAttribute("controller", "SobremesaController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
