package com.stefanini.produtos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.produtos.models.Categoria;
import com.stefanini.produtos.models.Produto;
import com.stefanini.produtos.repository.CategoriaRepository;
import com.stefanini.produtos.service.exceptions.NomeNuloException;
import com.stefanini.produtos.service.exceptions.ProductNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public void salvar(Categoria categoria){
		categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria buscar(long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ProductNotFoundException("Categoria não encontrada! Id: " +id + ", Tipo: " + Categoria.class.getName())); 
	}
	
}
