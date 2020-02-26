package com.stefanini.produtos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stefanini.produtos.models.Produto;
import com.stefanini.produtos.service.ProdutoService;

@RestController
@RequestMapping(value ="/")
public class ProdutoResource {

	@Autowired
	ProdutoService produtoService;
	
	@GetMapping(value="")
	public ResponseEntity<List<Produto>> listar(){
		List<Produto> lista = produtoService.find();
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping(value="produtos/add")
	public ResponseEntity<Void> criarProduto(@RequestBody Produto produto) {
		
		produtoService.salvar(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
}
