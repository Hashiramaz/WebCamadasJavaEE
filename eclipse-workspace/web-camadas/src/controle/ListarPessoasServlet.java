package controle;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import dao.PessoaDAO;
import model.Pessoa;
import util.FabricaConexao;

/**
 * Servlet implementation class ListarPessoasServlet
 */
@WebServlet("/ListarPessoasServlet")
public class ListarPessoasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPessoasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerconexao();
			
			PessoaDAO dao = new PessoaDAO(conexao);
			
			List<Pessoa> listaPessoas = dao.listarTodos();
			request.setAttribute("listarPessoas", listaPessoas);
			
			javax.servlet.RequestDispatcher despachante =  request.getRequestDispatcher("/listarPessoas.jsp");
			despachante.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
