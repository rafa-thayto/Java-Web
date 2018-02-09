package br.senai.sp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.dao.UsuarioDAO;
import br.senai.sp.model.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
			super();
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			System.out.println("primeiro");
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");

			// System.out.println(usuario + senha);
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario retorno = usuarioDAO.buscarUsuario(usuario, senha);
		
			if (retorno != null) {
				HttpSession session = 
						request.getSession();
				// vincular um elemento na sessão
				session
				.setAttribute("session_usuario", retorno);
				response
				.sendRedirect("admin/administrador.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}

	}

}
