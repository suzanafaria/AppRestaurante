package com.springboot.pizzaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pizzaria.model.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

}
