package com.springboot.pizzaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pizzaria.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
