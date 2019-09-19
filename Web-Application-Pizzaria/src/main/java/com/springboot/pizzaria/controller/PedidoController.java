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

import com.springboot.pizzaria.dao.PedidoRepository;
import com.springboot.pizzaria.model.Pedido;

@Controller
public class PedidoController {

	private PedidoRepository repository;
	
	public PedidoController(PedidoRepository repository) {
		this.repository = repository;
	}
	
	
	@RequestMapping("/pedido")
	public String index(Model model) {
		
		List<Pedido> pedidos = this.repository.findAll();
			
		model.addAttribute("pedidos", pedidos);
		return "pedido/pedidoLista";
	}
	
	
	// inserir Pedido
	@RequestMapping("/pedido/inserir")
	public String inserir(Model model) {
		Pedido pedido = new Pedido();
		model.addAttribute("pedido", pedido);
		return "pedido/pedidoCadastro";
	}

	@RequestMapping(value = "/pedido/inserirAction", method = RequestMethod.POST)
	public String inserirAction(@ModelAttribute("pedido") Pedido pedido, 
			BindingResult result, 
			ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		this.repository.save(pedido);

		model.addAttribute("pedidos", this.repository.findAll());
		model.addAttribute("mensagem", "Salvo com sucesso !");

		return "pedido/pedidoLista";
	}

	// alterar Pedido
	@RequestMapping("/pedido/alterar/{id}")
	public String alterar(Model model, 
			@PathVariable(value = "id") int id) {

		Optional<Pedido> pedido = this.repository.findById(id);
		model.addAttribute("pedido", pedido.get());
		return "pedido/pedidoAlterar";
	}

	@RequestMapping(value = "/pedido/alterarAction", method = RequestMethod.POST)
	public String alterarAction(@ModelAttribute("pedido") Pedido pedido, 
			BindingResult result, 
			ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		this.repository.save(pedido);

		model.addAttribute("mensagem", "Dado alterado ! eee !");
		model.addAttribute("pedidos", this.repository.findAll());

		return "pedido/pedidoLista";
	}
			
	
	// excluir Pedido
	@RequestMapping("pedido/remover/{id}")
	public String remover(Model model, 
			@PathVariable(value = "id") int id) {
		this.repository.deleteById(id);
		model.addAttribute("mensagem", "Dado removido !");
		model.addAttribute("pedidos", this.repository.findAll());
		return "pedido/pedidoLista";
	}
}
