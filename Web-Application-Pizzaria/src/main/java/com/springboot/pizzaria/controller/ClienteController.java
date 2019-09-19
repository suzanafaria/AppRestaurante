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

import com.springboot.pizzaria.dao.ClienteRepository;
import com.springboot.pizzaria.model.Cliente;

@Controller
public class ClienteController {

	private ClienteRepository repository;
	
	public ClienteController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	
	@RequestMapping("/cliente")
	public String index(Model model) {
		
		List<Cliente> clientes = this.repository.findAll();
			
		model.addAttribute("clientes", clientes);
		return "cliente/clienteLista";
	}
	
	
	// inserir Cliente
	@RequestMapping("/cliente/inserir")
	public String inserir(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cliente/clienteCadastro";
	}

	@RequestMapping(value = "/cliente/inserirAction", method = RequestMethod.POST)
	public String inserirAction(
			@ModelAttribute("cliente") Cliente cliente, 
			BindingResult result, 
			ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		this.repository.save(cliente);

		model.addAttribute("clientes", this.repository.findAll());
		model.addAttribute("mensagem", "Salvo com sucesso !");

		return "cliente/clienteLista";
	}
	
	
	// alterar Cliente
	@RequestMapping("/cliente/alterar/{id}")
	public String alterar(Model model, 
			@PathVariable(value = "id") int id) {

		Optional<Cliente> cliente = this.repository.findById(id);
		model.addAttribute("cliente", cliente.get());
		return "cliente/clienteAlterar";
	}

	@RequestMapping(value = "/cliente/alterarAction", method = RequestMethod.POST)
	public String alterarAction(@ModelAttribute("cliente") Cliente cliente, 
			BindingResult result, 
			ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		this.repository.save(cliente);

		model.addAttribute("mensagem", "Dado alterado ! eee !");
		model.addAttribute("clientes", this.repository.findAll());

		return "cliente/clienteLista";
	}
	
	
	// excluir Cliente
	@RequestMapping("cliente/remover/{id}")		
    public String remover(Model model, @PathVariable(value="id") int id){
        this.repository.deleteById(id);
        model.addAttribute("mensagem", "Dado removido !");
        model.addAttribute("clientes", this.repository.findAll());
        return "cliente/clienteLista";
    }
}
