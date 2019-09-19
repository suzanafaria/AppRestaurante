package com.springboot.pizzaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.pizzaria.dao.BebidaRepository;
import com.springboot.pizzaria.model.Bebida;
import com.springboot.pizzaria.model.Cliente;

@Controller
public class BebidaController {

	private BebidaRepository repository;
	
	public BebidaController(BebidaRepository repository) {
		this.repository = repository;
	}
	
	@RequestMapping("/bebida")
	public String index(Model model) {
		
		List<Bebida> bebidas = this.repository.findAll();
			
		model.addAttribute("bebidas", bebidas);
		return "bebida/bebidaLista";
	}
	
	
	// inserir Bebida
	@RequestMapping("/bebida/inserir")
	public String inserir(Model model) {
		Bebida bebida = new Bebida();
		model.addAttribute("bebida", bebida);
		return "bebida/bebidaCadastro";
	}
	
	@RequestMapping(value = "/bebida/inserirAction", method = RequestMethod.POST)
	public String inserirAction(
			@ModelAttribute("bebida") Bebida bebida, 
			BindingResult result, 
			ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		this.repository.save(bebida);

		model.addAttribute("bebidas", this.repository.findAll());
		model.addAttribute("mensagem", "Salvo com sucesso !");

		return "bebida/bebidaLista";
	}
	
		
	// alterar Bebida
	@RequestMapping("/bebida/alterar/{id}")
	public String alterar(Model model, 
			@PathVariable(value = "id") int id) {

		Optional<Bebida> bebida = this.repository.findById(id);
		model.addAttribute("bebida", bebida.get());
		return "bebida/bebidaAlterar";
	}

	@RequestMapping(value = "/bebida/alterarAction", method = RequestMethod.POST)
	public String alterarAction(@ModelAttribute("bebida") Bebida bebida, 
			BindingResult result, 
			ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		this.repository.save(bebida);

		model.addAttribute("mensagem", "Dado alterado ! eee !");
		model.addAttribute("bebidas", this.repository.findAll());

		return "bebida/bebidaLista";
	}
	
	
	// excluir Bebida
	@RequestMapping("bebida/remover/{id}")		
    public String remover(Model model, @PathVariable(value="id") int id){
        this.repository.deleteById(id);
        model.addAttribute("mensagem", "Dado removido !");
        model.addAttribute("bebidas", this.repository.findAll());
        return "bebida/bebidaLista";
    }
	
	
	
}
