package br.senai.sp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.LivroDAO;
import br.senai.sp.model.Livro;

/**
 * Servlet implementation class AdicionarLivroServlet
 */
@WebServlet("/adicionarLivro")
public class AdicionarLivroServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	} */
	
	@Override
	protected void doPost(HttpServletRequest req
			, HttpServletResponse resp) throws ServletException
			, IOException {
		//PrintWriter out = resp.getWriter();

		String nome = req.getParameter("nome");
		String autor = req.getParameter("autor");

		Livro livro = new Livro();
		livro.setNome(nome);
		livro.setAutor(autor);

		LivroDAO livroDAO = new LivroDAO();
		livroDAO.salva(livro);

//		out.println("<html>");
//		out.println("<body>");
//		out.println("Livro " + livro.getNome() + " adicionado com sucesso.");
//		out.println("</body>");
//		out.println("</html>");
		RequestDispatcher rd = 
				req.getRequestDispatcher
				("/livro-adicionado.jsp");
		rd.forward(req, resp);

	}
}
