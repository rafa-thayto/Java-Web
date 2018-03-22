package br.com.senai.sp.informatica.tecnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.sp.informatica.tecnow.dao.AnimeDAO;
import br.com.senai.sp.informatica.tecnow.model.Anime;
import br.com.senai.sp.informatica.tecnow.model.Game;
import br.com.senai.sp.informatica.tecnow.utils.SessionUtils;

@Controller
@RequestMapping("/app/animes")
public class AnimeController {
	
	@Autowired
	private SessionUtils sessionUtils;
	@Autowired
	private AnimeDAO animeDAO;
	
	@GetMapping(value = {"/", ""})
	public String openAnimes() {
		return "app/animes/index";
	}
	
	// Form
	@GetMapping("/cadastro")
	public String openForm() {
		return "app/animes/anime-form";
	}
	
	@PostMapping("/salvar")
	public String save(Anime anime) {
		
		try {
			
			if (anime.getId() == null) {
				anime.setUser(sessionUtils.getLoggedUser());
				animeDAO.insert(anime);
			} else {
				animeDAO.change(anime);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return "redirect:app/";
	} // End form
}
