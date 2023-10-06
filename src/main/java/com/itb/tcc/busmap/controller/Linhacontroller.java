package com.itb.tcc.busmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.tcc.busmap.model.Linha;
import com.itb.tcc.busmap.repository.LinhaRepository;

@Controller
@RequestMapping("/busmap/linha")
public class Linhacontroller {
	
	@Autowired
	private LinhaRepository linhaRepository;
	

	@GetMapping("/nova-linha")
	public String showFormLinha(Linha linha ,Model model) {
		
		model.addAttribute("linha", linha);
		return "addlinha";
		
		
	}
	
	@PostMapping("/addlinha")
	public String InsertLinha(Model model, Linha linha) {
		
		linha.setCodStatusLinha(true);
		Linha busmapbd = linhaRepository.save(linha);
		
		return "redirect:/busmap/linha/home";
	}
	
	@GetMapping("/home")
	public String showHome(Linha linha ,Model model) {
		return "home";
	}
}
