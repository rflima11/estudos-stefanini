package com.stefanini.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.produtos.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
