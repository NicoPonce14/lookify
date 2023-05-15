package com.nicolas.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nicolas.lookify.models.Cancion;
import com.nicolas.lookify.services.CancionServ;

import jakarta.validation.Valid;

@Controller
public class CancionController {

	@Autowired
	private CancionServ serv;
	
	@GetMapping("/")
	public String raiz() {
		return "index.jsp";
	}
	//trae todos los datos de la BDs
	@GetMapping("/dashboard")
	public String dashboard( Model m) {
		List<Cancion> canc = serv.allCanciones();
		m.addAttribute("canc", canc);
		return "dashboard.jsp";
	}
	
	//METODO QUE ELIMINA UNA CANCION
	@GetMapping("/delete/{id}")
	public String eliminarCancion(@PathVariable("id") Long id) {
		serv.deleteCancion(id);
		return "redirect:/dashboard";
	}
	
	//crear cancion
	
	@GetMapping("/songs/new")
	public String nuevo(@ModelAttribute("cancion") Cancion cancion) {
		return "new.jsp";
	}
	
	@PostMapping("/songs/new")
	public String nuevaCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult binding) {
		if (binding.hasErrors()) {
			return "new.jsp";
		} else {
			serv.createCancion(cancion);
			return "redirect:/dashboard";
		}
	}
	
	//METODO PARA MOSTRAR UN SOLO REGISTRO EN LA VISTA SHOW.JSP
	@GetMapping("/songs/{id}")
	public String mostrarCancion(Model m, @PathVariable("id") Long id) {
		m.addAttribute("cancion",serv.findCancion(id));
		return "show.jsp";
	}
	
	//metodo para mostrar el top ten de canciones
	/*@GetMapping("/search/topten")
	public String topten(Model m) {
		m.addAttribute("topten",serv.findtop10());
		return "topten.jsp";
	}*/
	
	@GetMapping("/search/topten")
	public String topTen(Model viewModel) {
		List<Cancion> topTen = serv.topTen();
		viewModel.addAttribute("topTen", topTen);
		return "topten.jsp";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam(value="q") String q,Model m) {
		List<Cancion> busqueda = serv.searchbyArtist(q);
		m.addAttribute("q",q);
		m.addAttribute("busqueda",busqueda);
		return "search.jsp";
	}

	
}
