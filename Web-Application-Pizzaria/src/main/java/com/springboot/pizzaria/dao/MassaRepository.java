package com.springboot.pizzaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pizzaria.model.Massa;

@Repository
public interface MassaRepository extends JpaRepository<Massa, Integer>{

}
