package com.springboot.pizzaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pizzaria.dao.ClienteRepository;
import com.springboot.pizzaria.model.Cliente;

@RestController
@RequestMapping("/rest/cliente")
public class ClienteRestController {

	private ClienteRepository repository;
	
	public ClienteRestController(ClienteRepository repository){
        this.repository = repository;
    }
	
	
	@GetMapping()
    public List<Cliente> list(){
        return this.repository.findAll();
    }
	
	
	@GetMapping("/{id}")
    public Object get(@PathVariable int id){
        Optional<Cliente> cliente = this.repository.findById(id);
        if(cliente.isPresent()){
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }        
    }
	
	
	@PostMapping
    public Cliente post(@RequestBody Cliente cliente){
        return this.repository.save(cliente);
    }
	
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Optional<Cliente> cliente = this.repository.findById(id);
        if(cliente.isPresent()){
            this.repository.delete(cliente.get());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	
	@PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable int id, 
                                 @RequestBody Cliente newCliente){
        
       Optional<Cliente> oldCliente = this.repository.findById(id);
       if(oldCliente.isPresent()){
    	   newCliente.setId(id);
           this.repository.save(newCliente);
           return new ResponseEntity<>(newCliente, HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

    }

	
	
	
}
