package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDao;
import negocio.Bebida;
import negocio.Comida;
import negocio.Sobremesa;

public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProdutoController() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("operacao") != null) {
			request.getRequestDispatcher("produtoCadastro.jsp").forward(request, response);
		} else {
			request.setAttribute("produtos", ProdutoDao.obterLista());
			request.getRequestDispatcher("produtoCadastro.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String codigo = request.getParameter("codigo");
		float preco = Float.valueOf(request.getParameter("preco"));
		
		
		if (("bebida").equals(request.getParameter("tipo"))) {
			Bebida bebida = new Bebida(codigo, nome, preco);
			
			request.getSession().setAttribute("newBebida", bebida);
			
			request.getRequestDispatcher("bebidaCadastro.jsp").forward(request, response);
			
		} else {
			if(("comida").equals(request.getParameter("tipo"))) {
				Comida comida = new Comida(codigo, nome, preco);
				request.getSession().setAttribute("newComida", comida);
				request.getRequestDispatcher("comidaCadastro.jsp").forward(request, response);
				
				
			} else {
				if (("sobremesa").equals(request.getParameter("tipo"))) {
					Sobremesa sobremesa = new Sobremesa(codigo, nome, preco);
					request.getSession().setAttribute("newSobremesa", sobremesa);
					request.getRequestDispatcher("sobremesaCadastro.jsp").forward(request, response);
				}
			}
		}
	}

}
