package com.stefanini.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.produtos.models.Categoria;

@Repository	
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
