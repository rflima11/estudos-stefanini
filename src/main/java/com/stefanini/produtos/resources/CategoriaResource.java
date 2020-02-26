package com.stefanini.produtos.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stefanini.produtos.dto.CategoriaDTO;
import com.stefanini.produtos.models.Categoria;
import com.stefanini.produtos.service.CategoriaService;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaResource {

	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping(value="/")
	public ResponseEntity<List<CategoriaDTO>> listar(){
		List<Categoria> lista = categoriaService.listAll();
		List<CategoriaDTO> listDto = lista.stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping(value="/")
	public ResponseEntity<Void> salvar(@RequestBody Categoria categoria){
		categoriaService.salvar(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable long id){
		return ResponseEntity.ok().body(categoriaService.buscar(id));
	}
	
}
