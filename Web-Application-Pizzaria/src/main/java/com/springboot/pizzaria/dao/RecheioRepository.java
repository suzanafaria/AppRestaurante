package com.springboot.pizzaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pizzaria.model.Recheio;

@Repository
public interface RecheioRepository extends JpaRepository<Recheio, Integer>{

}
