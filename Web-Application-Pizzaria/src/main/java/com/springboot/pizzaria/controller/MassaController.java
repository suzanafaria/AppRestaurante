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

import com.springboot.pizzaria.dao.MassaRepository;
import com.springboot.pizzaria.model.Massa;

@Controller
public class MassaController {

	private MassaRepository repository;
	
	public MassaController(MassaRepository repository){
		this.repository=repository;
	}
	
	
	@RequestMapping("/massa")
    public String index(Model model) {
        
        List<Massa> massas = this.repository.findAll();
        
        model.addAttribute("massas", massas);
        return "/massa/massaLista";
    }
	
	
	//inserir Massa
	@RequestMapping("/massa/inserir")	
	public String inserir(Model model){
        Massa massa = new Massa();
        model.addAttribute("massa", massa);
        return "massa/massaCadastro";
    }
	
	@RequestMapping(value = "/massa/inserirAction", method = RequestMethod.POST)
    public String inserirAction(@ModelAttribute("massa") Massa massa, 
            BindingResult result,
            ModelMap model){
        if(result.hasErrors()){
            return "error";
        }
        
        this.repository.save(massa);
        
        model.addAttribute("massas", this.repository.findAll());
        model.addAttribute("mensagem", "Salvo com sucesso !");
        
        return "massa/massaLista";
    }
	
		
	// alterar Massa
	@RequestMapping("/massa/alterar/{id}")
    public String alterar(Model model, 
            @PathVariable(value="id") int id){
        
        Optional<Massa> massa = this.repository.findById(id);
        model.addAttribute("massa", massa.get());
        return "massa/massaAlterar";
    }
	
	@RequestMapping(value = "/massa/alterarAction", method = RequestMethod.POST)
    public String alterarAction(
            @ModelAttribute("massa") Massa massa,
            BindingResult result,
            ModelMap model
            ){
        
        if(result.hasErrors()){
            return "error";
        }
        
        this.repository.save(massa);
        model.addAttribute("mensagem", "Dado alterado ! eee !");
        model.addAttribute("massas", this.repository.findAll());
        return "massa/massaLista";
        
    }
	
	//excluir Massa
	@RequestMapping("massa/remover/{id}")		
    public String remover(Model model, @PathVariable(value="id") int id){
        this.repository.deleteById(id);
        model.addAttribute("mensagem", "Dado removido !");
        model.addAttribute("massas", this.repository.findAll());
        return "massa/massaLista";
    }
	
}
