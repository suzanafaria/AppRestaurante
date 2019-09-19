package com.springboot.pizzaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pizzaria.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
