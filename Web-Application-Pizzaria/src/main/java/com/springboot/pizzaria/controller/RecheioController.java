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

import com.springboot.pizzaria.dao.RecheioRepository;
import com.springboot.pizzaria.model.Recheio;


@Controller
public class RecheioController {

	
	private RecheioRepository repository;
	
	public RecheioController(RecheioRepository repository) {
		this.repository = repository;
	}
	

	@RequestMapping("/recheio")
	public String index(Model model) {
		
		List<Recheio> recheios = this.repository.findAll();
			
		model.addAttribute("recheios", recheios);
		return "recheio/recheioLista";
	}
	
	
	// inserir Recheio
	@RequestMapping("/recheio/inserir")
	public String inserir(Model model){
        Recheio recheio = new Recheio();
        model.addAttribute("recheio", recheio);
        return "recheio/recheioCadastro";
    }
		
	@RequestMapping(value = "/recheio/inserirAction", method = RequestMethod.POST)
    public String inserirAction(
    		@ModelAttribute("recheio") Recheio recheio, 
            BindingResult result,
            ModelMap model){
        if(result.hasErrors()){
            return "error";
        }
        
        this.repository.save(recheio);
        
        model.addAttribute("recheios", this.repository.findAll());
        model.addAttribute("mensagem", "Salvo com sucesso !");
        
        return "recheio/recheioLista";
    }
	
	
	// alterar Recheio
	@RequestMapping("/recheio/alterar/{id}")
    public String alterar(Model model, 
            @PathVariable(value="id") int id){
        
        Optional<Recheio> recheio = this.repository.findById(id);
        model.addAttribute("recheio", recheio.get());
        return "recheio/recheioAlterar";
    }
	
	@RequestMapping(value = "/recheio/alterarAction", method = RequestMethod.POST)
    public String alterarAction(
    		@ModelAttribute("recheio") Recheio recheio, 
            BindingResult result,
            ModelMap model){
        if(result.hasErrors()){
            return "error";
        }
        
        this.repository.save(recheio);
        
        model.addAttribute("mensagem", "Dado alterado ! eee !"); 
        model.addAttribute("recheios", this.repository.findAll());
               
        return "recheio/recheioLista";
    }
	
		
	// excluir Recheio
	@RequestMapping("recheio/remover/{id}")		
    public String remover(Model model, @PathVariable(value="id") int id){
        this.repository.deleteById(id);
        model.addAttribute("mensagem", "Dado removido !");
        model.addAttribute("recheios", this.repository.findAll());
        return "recheio/recheioLista";
    }
	
}
