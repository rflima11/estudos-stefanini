package com.stefanini.produtos.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.produtos.models.Produto;
import com.stefanini.produtos.repository.ProdutoRepository;
import com.stefanini.produtos.service.exceptions.NomeNuloException;
import com.stefanini.produtos.service.exceptions.ProductNotFoundException;

@RestController
@RequestMapping(value = "/api")
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	

	public Produto buscar(long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ProductNotFoundException("Produto não encontrado! Id: " +id + ", Tipo: " + Produto.class.getName())); 
	}
	
	public void salvar(Produto produto) {
	try {
		produtoRepository.save(produto);
	} catch (Exception e) {
		throw new NomeNuloException("Não é possível adicionar um produto com o nome nulo");
	}
	}
	
	public List<Produto> find(){
		return produtoRepository.findAll();
	}

}
