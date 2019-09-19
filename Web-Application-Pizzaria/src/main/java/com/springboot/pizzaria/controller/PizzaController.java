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

import com.springboot.pizzaria.dao.PizzaRepository;
import com.springboot.pizzaria.model.Pizza;

@Controller
public class PizzaController {

	private PizzaRepository repository;
	
	public PizzaController(PizzaRepository repository) {
		this.repository = repository;
	}
	
	
	@RequestMapping("/pizza")
	public String index(Model model) {
		
		List<Pizza> pizzas = this.repository.findAll();
			
		model.addAttribute("pizzas", pizzas);
		return "pizza/pizzaLista";
	}
	
	
	// inserir Pizza
		@RequestMapping("/pizza/inserir")
		public String inserir(Model model) {
			Pizza pizza = new Pizza();
			model.addAttribute("pizza", pizza);
			return "pizza/pizzaCadastro";
		}
	
		@RequestMapping(value = "/pizza/inserirAction", method = RequestMethod.POST)
		public String inserirAction(
				@ModelAttribute("pizza") Pizza pizza, 
				BindingResult result, 
				ModelMap model) {
			if (result.hasErrors()) {
				return "error";
			}

			this.repository.save(pizza);

			model.addAttribute("pizzas", this.repository.findAll());
			model.addAttribute("mensagem", "Salvo com sucesso !");

			return "pizza/pizzaLista";
		}
	
		// alterar Pizza
		@RequestMapping("/pizza/alterar/{id}")
		public String alterar(Model model, 
				@PathVariable(value = "id") int id) {

			Optional<Pizza> pizza = this.repository.findById(id);
			model.addAttribute("pizza", pizza.get());
			return "pizza/pizzaAlterar";
		}

		@RequestMapping(value = "/pizza/alterarAction", method = RequestMethod.POST)
		public String alterarAction(@ModelAttribute("pizza") Pizza pizza, 
				BindingResult result, 
				ModelMap model) {
			if (result.hasErrors()) {
				return "error";
			}

			this.repository.save(pizza);

			model.addAttribute("mensagem", "Dado alterado ! eee !");
			model.addAttribute("pizzas", this.repository.findAll());

			return "pizza/pizzaLista";
		}
		
		
		// excluir Pizza
		@RequestMapping("pizza/remover/{id}")		
	    public String remover(Model model, @PathVariable(value="id") int id){
	        this.repository.deleteById(id);
	        model.addAttribute("mensagem", "Dado removido !");
	        model.addAttribute("pizzas", this.repository.findAll());
	        return "pizza/pizzaLista";
	    }
	
	
}
