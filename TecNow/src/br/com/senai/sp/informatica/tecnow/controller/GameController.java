package br.com.senai.sp.informatica.tecnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.sp.informatica.tecnow.dao.GameDAO;
import br.com.senai.sp.informatica.tecnow.model.Game;
import br.com.senai.sp.informatica.tecnow.utils.SessionUtils;

@Controller
@RequestMapping("/app/jogos")
public class GameController {
	
	@Autowired
	private SessionUtils sessionUtils;
	@Autowired
	private GameDAO gameDAO;
	
	@GetMapping(value = {"/", ""})
	public String openGames() {
		return "app/games/index";
	}
	
	// Form
	@GetMapping("/cadastro")
	public String openForm() {
		return "app/games/game-form";
	}
	
	@PostMapping("/salvar")
	public String save(Game game) {
		
		try {
			
			if (game.getId() == null) {
				game.setUser(sessionUtils.getLoggedUser());
				gameDAO.insert(game);
			} else {
				gameDAO.change(game);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return "redirect:app/";
	} // End form
}
