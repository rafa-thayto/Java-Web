package br.senai.sp.informatica.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.dao.GameDAO;
import br.senai.sp.informatica.model.Game;

@WebServlet("/addGame")
public class AddGameServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String dev = req.getParameter("dev");
		
		Game game = new Game();
		game.setName(name);
		game.setDev(dev);
		
		GameDAO dao = new GameDAO();
		dao.save(game);
		
		RequestDispatcher rd = req
				.getRequestDispatcher("/added-game.jsp");
		rd.forward(req, resp);
	}
	
}
