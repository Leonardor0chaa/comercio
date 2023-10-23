package com.itb.tcc.busmap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.tcc.busmap.model.Linha;
import com.itb.tcc.busmap.repository.LinhaRepository;

@Controller
@RequestMapping("/busmap/linha")
public class Linhacontroller {
	
	List<Linha> arrayLinhas = new ArrayList<>();
	
	@Autowired
	private LinhaRepository linhaRepository;
	

	@GetMapping("/nova-linha")
	public String showFormLinha(Linha linha ,Model model) {
		
		model.addAttribute("linha", linha);
		return "frmlinha";
		
		
	}
	
	@PostMapping("/addlinha")
	public String insertLinha(Model model, Linha linha) {
		
		linha.setCodStatusLinha(true);
		Linha busmapbd = linhaRepository.save(linha);
		
		return "redirect:/busmap/linha/todas-linhas";
	}
	
	@GetMapping("/todas-linhas")
	public String showLinhaRua(Linha linha ,Model model) {
		
		arrayLinhas = linhaRepository.findAll();
		
		model.addAttribute("arrayLinhas", arrayLinhas);
		
		return "listalinhas";
	}
	
	@GetMapping("/editar-linha/{id}")
	public String showUpdateForm(@PathVariable("id") long id, ModelMap model) {
		
		// select a linha pelo id 
		
		
		Linha linhaDb = linhaRepository.getById(id);
		
		model.addAttribute("linha", linhaDb);
		return "frmeditarlinha";
	}
	
	@PostMapping("/update") 
	public String insertEditar(@ModelAttribute("linha") Linha linha){
		
		
		
		linhaRepository.save(linha);
		return "redirect:/busmap/linha/todas-linhas";
	}
	

	@GetMapping("/excluir-linha/{id}")
	public String Deletelinha(@PathVariable("id") long id, ModelMap model) {
		
		// select a linha pelo id
		
		Linha linhaDb = linhaRepository.getById(id);
		linhaRepository.delete(linhaDb);
		
		return "redirect:/busmap/linha/todas-linhas";
	}
}
