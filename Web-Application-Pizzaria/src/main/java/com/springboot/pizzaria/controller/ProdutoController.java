package com.springboot.pizzaria.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.pizzaria.dao.ProdutoRepository;
import com.springboot.pizzaria.model.Produto;

@Controller
public class ProdutoController {

	private ProdutoRepository repository;
	
	public ProdutoController(ProdutoRepository repository){
		this.repository=repository;
	}
	
	@RequestMapping("/produto")
    public String index(Model model) {
        
        List<Produto> produtos = this.repository.findAll();
        
        model.addAttribute("produtos", produtos);
        return "/produto/produtoLista";
    }
	
	
	
	//excluir Produto
		@RequestMapping("produto/remover/{id}")		
	    public String remover(Model model, @PathVariable(value="id") int id){
	        this.repository.deleteById(id);
	        model.addAttribute("mensagem", "Dado removido !");
	        model.addAttribute("produtos", this.repository.findAll());
	        return "produto/produtoLista";
	    }
	
	
	
	
}
