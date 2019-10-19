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
	
    public BebidaController() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idProduto") != null) {
			BebidaDao.excluir(Integer.valueOf(request.getParameter("idProduto")));
			request.setAttribute("bebidas", BebidaDao.obterLista());
			request.getRequestDispatcher("bebidaLista.jsp").forward(request, response);
			
		}else {		
		if(request.getParameter("operacao") != null) {
				request.getRequestDispatcher("bebidaCadastro.jsp").forward(request, response);
			} else {	
				request.setAttribute("bebidas", BebidaDao.obterLista());
				request.getRequestDispatcher("bebidaLista.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Bebida bebida = new Bebida(
				request.getParameter("codigo"),
				request.getParameter("nome"),
				Float.valueOf(request.getParameter("preco")),
				request.getParameter("marca"),
				request.getParameter("tamanho"),
				Boolean.valueOf(request.getParameter("alcoolica")));	
	
		BebidaDao.incluir(bebida);
		
		request.setAttribute("mensagem", "Cadastro realizado com sucesso "+bebida.toString());
		request.setAttribute("titulo", "Bebida");
		request.setAttribute("controller", "BebidaController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);

	}

}
